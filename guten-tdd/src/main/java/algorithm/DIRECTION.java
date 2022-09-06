package algorithm;

import java.util.Arrays;

public enum DIRECTION {

    NORTH(0, new int[]{-1, 0}),
    SOUTH(2, new int[]{1, 0}),
    WEST(3, new int[]{0, -1}),
    EAST(1, new int[]{0, 1});

    private int value;
    private int[] moveDirection;
    DIRECTION(int value, int[] moveDirection) {
        this.value = value;
        this.moveDirection = moveDirection;
    }

    public DIRECTION turnLeft(){
        int turnLeftDirection = this.value - 1;
        if (turnLeftDirection < 0)
            turnLeftDirection = 3;
        return getDirection(turnLeftDirection);
    }

    public static DIRECTION getDirection(int value){
        return Arrays.stream(DIRECTION.values())
                .filter(d -> d.value == value)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public int[] getMoveDirection() {
        return this.moveDirection;
    }

    public int getValue() {
        return value;
    }
}

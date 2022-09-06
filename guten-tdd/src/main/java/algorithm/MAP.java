package algorithm;

import java.util.Arrays;

public enum MAP {
    LAND(0),
    SEA(1);

    private int value;

    MAP(int value) {
        this.value = value;
    }

    public static MAP getLand(int value){
        return Arrays.stream(MAP.values())
                .filter(d -> d.value == value)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}

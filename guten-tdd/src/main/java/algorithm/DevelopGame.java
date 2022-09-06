package algorithm;

/**
 * @author gutenlee
 * @since 2022/09/06
 */
public class DevelopGame {
    private int[][] map;
    private int[][] mapForCheck;
    private int[] currentXY;
    private DIRECTION currentDirection;

    public DevelopGame(int[][] map, int[] currentXY, DIRECTION currentDirection) {
        this.map = map;
        this.currentXY = currentXY;
        this.currentDirection = currentDirection;

        mapForCheck = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                mapForCheck[i][j] = 0;
            }
        }
        checked(currentXY);
    }

    private boolean isPossibleToMove(int[] turnLeftXY){
        int x = currentXY[0] + turnLeftXY[0];
        int y = currentXY[1] + turnLeftXY[1];

        if ((x < 0 || x >= map.length) || (y < 0 || y >= map.length))
            return false;
        else
            return map[x][y] == 0 || mapForCheck[x][y] == 0;
    }

    private void checked(int[] position){
        this.mapForCheck[position[0]][position[1]] = 1;
    }

    private void move(int[] movetoXY){
        currentXY[0] = currentXY[0] + movetoXY[0];
        currentXY[1] = currentXY[1] + movetoXY[1];
        checked(currentXY);
    }

    public int moveTest() {
        int count = 0;
        int turnTime = 0;
        while (true) {
            DIRECTION turnLeft = this.currentDirection.turnLeft();
            if (isPossibleToMove(turnLeft.getMoveDirection())) {
                move(turnLeft.getMoveDirection());
                count++;
                continue;
            } else {
                turnTime++;
            }
            if (turnTime == 4) {
                this.currentDirection = currentDirection.turnLeft();
                this.currentDirection = currentDirection.turnLeft();
                int[] moveDirection = this.currentDirection.getMoveDirection();
                if (isPossibleToMove(moveDirection)) {
                    move(moveDirection);
                    checked(currentXY);
                }
                else
                    break;
                turnTime = 0;
            }
        }
        return count;
    }
}

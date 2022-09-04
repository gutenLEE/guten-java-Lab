package algorithm;

/**
 * @author gutenlee
 * @since 2022/09/04
 */
public class Move {
    private int x;
    private int y;
    private int boundary;

    public Move(int boundary) {
        this.x = 1;
        this.y = 1;
        this.boundary = boundary;
    }

    public void goTo(String direction) {
        switch (direction) {
            case "U":
                if (x == 1)break;
                x--;
                break;
            case "D":
                if (x == boundary) break;
                x++;
                break;
            case "R":
                if (y == boundary) break;
                y++;
                break;
            case "L":
                if (y == 1) break;
                y--;
                break;
        }
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}

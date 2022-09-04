package algorithm;

/**
 * @author gutenlee
 * @since 2022/09/04
 */
public class Move {
    private int x;
    private int y;


    public void goTo(String direction) {
        switch (direction) {
            case "U":
                x--;
                break;
            case "D":
                x++;
                break;
            case "R":
                y++;
                break;
            case "L":
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

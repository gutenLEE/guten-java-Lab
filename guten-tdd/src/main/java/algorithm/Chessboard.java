package algorithm;

/**
 * @author gutenlee
 * @since 2022/09/04
 */
public class Chessboard {
    private int x;
    private int y;
    public Chessboard(String position) {
        convertToXY(position);
    }

    private void convertToXY(String position) {
        char y = position.charAt(0);
        char x = position.charAt(1);
        this.y = y - 97 + 1;
        this.x = x - 48;
    }

    public int getMovableCount(){
        int cnt = 0;
        if (movableRight()) {
            if (x+1 <= 8) cnt++;
            if (x-1 > 0) cnt++;
        }
        if (movableLeft()){
            if (x+1 <= 8) cnt++;
            if (x-1 > 0) cnt++;
        }
        if (movableUp()){
            if (y+1 <= 8) cnt++;
            if (y-1 > 0) cnt++;
        }
        if (movableDown()){
            if (y+1 <= 8) cnt++;
            if (y-1 > 0) cnt++;
        }
        return cnt;
    }

    public boolean movableRight(){
        return y < 7;
    }

    public boolean movableLeft() {
        return y > 2;
    }

    public boolean movableUp(){
        return x > 2;
    }

    public boolean movableDown() {
        return x < 7;
    }

    public int getNumberOfCases() {
        return 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

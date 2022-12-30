package effectivejava.Item16.dimension;

/**
 * @author gutenlee
 * @since 2022/12/28
 */
public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private class InnerClass {
        void accessMember(){
            x = 14;
            y = 12;
        }
    }

    public static void main(String[] args) {
        Point point = new Point(1, 2);

    }
}
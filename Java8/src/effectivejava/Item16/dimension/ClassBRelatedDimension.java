package effectivejava.Item16.dimension;

/**
 * @author gutenlee
 * @since 2022/12/28
 */
public class ClassBRelatedDimension {
    public static void main(String[] args) {
        Point point = new Point(1, 2);
        point.new InnerClass();
    }
}

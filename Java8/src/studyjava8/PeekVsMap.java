package studyjava8;

import java.util.Arrays;
import java.util.List;

/**
 * @author gutenlee
 * @since 2022/12/20
 */
public class PeekVsMap {
    public static void main(String[] args) {

        List<Point> points = Arrays.asList(new Point(12, 2), null);

        points.stream()
                .map(Point::getX)
                .forEach(System.out::println);

        points.stream()
                .map(p -> p.getX())
                .forEach(System.out::println);
    }
}


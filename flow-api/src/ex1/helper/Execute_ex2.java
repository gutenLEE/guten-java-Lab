package ex1.helper;

import ex1.ArithmeticCell;
import ex1.SimpleCell;

/**
 * @author yhlee
 * @since 2022-01-23 오후 10:42
 */
public class Execute_ex2 {
    public static void main(String[] args) {
        ArithmeticCell c3 = new ArithmeticCell("c3");
        SimpleCell c2 = new SimpleCell("c2");
        SimpleCell c1 = new SimpleCell("c1");

        c1.subscribe(c3);
        c2.subscribe(c3);
        c1.onNext(10);
        c2.onNext(20);
        c1.onNext(15);
    }

}

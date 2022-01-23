package ex1.helper;

import ex1.SimpleCell;

/**
 * @author yhlee
 * @since 2022-01-23 오후 10:30
 */
public class Execute_example {
    public static void main(String[] args) {
        SimpleCell c1 = new SimpleCell("c1");
        SimpleCell c2 = new SimpleCell("c2");
        SimpleCell c3 = new SimpleCell("c3");

        c1.subscribe(c3);

        c1.onNext(10);
        c2.onNext(20);

    }
}

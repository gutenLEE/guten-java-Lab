package proxypattern;

/**
 * @author gutenlee
 * @since 2022/10/05
 */
public class ExpensiveObjectProxy implements ExpensiveObject {

    private static ExpensiveObject object;

    @Override
    public void process() {
        if (object==null) {
            object = new ExpensiveObjectImpl();
        }
        object.process();
    }
}

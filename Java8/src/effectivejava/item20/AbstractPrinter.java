package effectivejava.item20;

/**
 * @author gutenlee
 * @since 2023/01/24
 */
public class AbstractPrinter extends Printer {

    public void print(){
        System.out.println("AbstractPrinter.print");
    }

    @Override
    public void doSomething() {

    }
}

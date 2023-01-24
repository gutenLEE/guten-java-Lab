package effectivejava.item20;

/**
 * @author gutenlee
 * @since 2023/01/24
 */
public class MultipleImplementation implements A, B {

    @Override
    public void drawA() {
        System.out.println("MultipleImplementation.drawA");
    }

    @Override
    public void drawB() {
        System.out.println("MultipleImplementation.drawB");
    }

    public void remove() {
        System.out.println("this should be override");
    }
}

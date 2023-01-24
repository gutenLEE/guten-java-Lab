package effectivejava.item20;

public interface B {

    void drawB();

    default void remove() {
        System.out.println("B.remove");
    }
}

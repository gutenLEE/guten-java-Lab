package effectivejava.item20;

public interface A {
    void drawA();
    default void remove(){
        System.out.println("A.remove");
    }
}

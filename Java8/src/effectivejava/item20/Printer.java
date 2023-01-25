package effectivejava.item20;

/**
 * @author gutenlee
 * @since 2023/01/24
 */
public abstract class Printer {
    
    public void print(){
        System.out.println("AbstractA.print");
    }

    public abstract void doSomething();

}

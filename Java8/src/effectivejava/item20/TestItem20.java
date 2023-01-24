package effectivejava.item20;

/**
 * @author gutenlee
 * @since 2023/01/24
 */
public class TestItem20 {
    public static void main(String[] args) {
        // 다중 구현 시 default메서드가 겹칠 경우
        MultipleImplementation m = new MultipleImplementation();
        System.out.println("----- cast to A ------");

        A a = m ;
        a.drawA();
        a.remove();

        System.out.println("-------------------");
        System.out.println("----- cast to B ------");
        B b = m;
        b.drawB();
        b.remove();

        System.out.println("-------------------");

        m.drawA();
        m.drawB();
        m.remove();
    }
}

package effectivejava.Item16;

/**
 * @author gutenlee
 * @since 2022/12/27
 */
public class ShadowTest {

    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("this -> " + this.getClass().getName());
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
            System.out.println("ShadowTest.this -> " + ShadowTest.this.getClass().getName());
        }
    }

    public static void main(String... args) {
        ShadowTest st = new ShadowTest();
        ShadowTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}

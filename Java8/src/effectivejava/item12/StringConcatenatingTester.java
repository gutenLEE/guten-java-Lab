package effectivejava.item12;

/**
 * @author gutenlee
 * @since 2022/12/13
 */
public class StringConcatenatingTester {
    public static void main(String[] args) {
        String A = "A";
        String B = "B";
        String append = A + B;

        StringBuilder sb = new StringBuilder("");
        sb.append("12");
        sb.toString();

    }
}

package effectivejava.item19;

import java.time.Instant;

/**
 * @author gutenlee
 * @since 2023/01/17
 */
public class Sub extends Super {

    private final Instant instant;

    public Sub() {
        instant = Instant.now();
    }

    @Override
    public void overrideMe() {
        System.out.println("Sub 에서 초기화된 instant : " + instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();;
    }
}

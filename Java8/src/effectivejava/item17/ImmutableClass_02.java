package effectivejava.item17;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * 불변 객체는 자유롭게 공유할 수 있음은 물론, 불변 객체끼리는 내부 데이터를 공유 가능함.
 *
 * @author gutenlee
 * @since 2023/01/04
 */
public class ImmutableClass_02 {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("10000000");
        BigInteger negate = a.negate();
    }
}

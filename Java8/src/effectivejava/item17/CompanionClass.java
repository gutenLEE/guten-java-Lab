package effectivejava.item17;

import java.math.BigInteger;

/**
 * 불변 객체의 단점을 보완하기 위한 가변동반 클래스
 * @author gutenlee
 * @since 2023/01/04
 */
public class CompanionClass {

    public static void main(String[] args) {

        String a = new String("a");

        BigInteger bigInteger = new BigInteger("123");
    }
}

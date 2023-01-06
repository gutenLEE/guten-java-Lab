package effectivejava.item17;

import java.math.BigInteger;

/**
 * BigInteger, BigDecimal 설계 결함. 재정의할 수 있게 설계되어서 하위 호환성이 발목을 잡음
 * 이 두 인스턴스를 인수로 받는다면 주의하라
 *
 * @author gutenlee
 * @since 2023/01/04
 */
public class ImmutableClass_01 extends BigInteger {
    public ImmutableClass_01(String val) {
        super(val);
    }

}

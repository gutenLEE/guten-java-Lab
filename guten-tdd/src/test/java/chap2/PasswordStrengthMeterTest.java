package chap2;

import org.assertj.core.internal.IterableElementComparisonStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
* @author gutenlee
* @since 2022/05/16
*/
public class PasswordStrengthMeterTest {


    // 가장 쉽거나 -> 모든 규칙을 충족하는 경우 --> 이게 더 쉽다
    // 가장 예외적인 상황 -> 모든 조건을 충족하지 않는 경우
    @Test
    void meetsAllCriteria_Then_String() throws Exception {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("asdf!2312");
        assertThat(result).isEqualTo(PasswordStrength.STRONG);

        PasswordStrength result2 = meter.meter("asdf!wefwef");
        assertThat(result2).isEqualTo(PasswordStrength.STRONG);
    }

    @Test
    @DisplayName("8글자 미만이고 나머지 조건은 충족하는 경우")
    void meetsOtherCritera_except_for_Length_Then_Normal () throws Exception {

        PasswordStrengthMeter meter = new PasswordStrengthMeter();

        PasswordStrength result = meter.meter("asdf12");
        assertThat(result).isEqualTo(PasswordStrength.NORMAL);

        PasswordStrength result2 = meter.meter("AAA123");
        assertThat(result2).isEqualTo(PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("숫자를 포함하지 않고 나머지 조건은 충족하는 경우")
    void meetsOtherCritera_except_for_number_Then_Normal () throws Exception {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();

        PasswordStrength result = meter.meter("ASDF@#$ASSDF");
        assertThat(result).isEqualTo(PasswordStrength.NORMAL);
    }


}

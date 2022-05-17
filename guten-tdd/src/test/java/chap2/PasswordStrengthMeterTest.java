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

    PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = meter.meter(password);
        assertThat(result).isEqualTo(expStr);
    }

    // 가장 쉽거나 -> 모든 규칙을 충족하는 경우 --> 이게 더 쉽다
    // 가장 예외적인 상황 -> 모든 조건을 충족하지 않는 경우
    @Test
    @DisplayName("모든 조건을 충족하는 경우")
    void meetsAllCriteria_Then_String() throws Exception {

        assertStrength("asd231ㅈㄷ234ㄹㅈㄷㄹㅈㄷㄹ2", PasswordStrength.STRONG);
        assertStrength("asdfㅈㄷㄹㅈㄷㄹㅈㄷㄹㅈㄷ234234ㄹ!wefwef", PasswordStrength.STRONG);
    }

    @Test
    @DisplayName("8글자 미만이고 나머지 조건은 충족하는 경우")
    void meetsOtherCritera_except_for_Length_Then_Normal () throws Exception {

        assertStrength("asdf12", PasswordStrength.NORMAL);
        assertStrength("AAA123", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("숫자를 포함하지 않고 나머지 조건은 충족하는 경우")
    void meetsOtherCritera_except_for_number_Then_Normal () throws Exception {

        assertStrength("ASDF@#$ASSDF", PasswordStrength.NORMAL);
        assertStrength("ASAㄸㄸSSDF", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("입력값이 Null인 경우")
    void nullInput_Then_Invalid () throws Exception {
        assertStrength(null, PasswordStrength.INVALID);
    }

    @Test
    @DisplayName("입력값이 공백 문자열인 경우")
    void emptyInput_Then_Invalid () throws Exception {
        assertStrength("", PasswordStrength.INVALID);
    }

    @Test
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal () throws Exception {
        assertStrength("asdfcvb1234!", PasswordStrength.NORMAL);
    }
}

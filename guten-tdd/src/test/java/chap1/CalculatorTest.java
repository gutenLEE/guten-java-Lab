package chap1;

import chap1.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author gutenlee
 * @since 2022/05/16
 */
public class CalculatorTest {
    @Test
    void calculator_test() throws Exception {
        int result = Calculator.plus(1, 2);

        assertThat(result).isEqualTo(3);
        assertThat(Calculator.plus(1, 4)).isEqualTo(5);
    }


}

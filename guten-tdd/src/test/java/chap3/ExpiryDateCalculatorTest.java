package chap3;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author gutenlee
 * @since 2022/05/19
 */
public class ExpiryDateCalculatorTest {

    @Test
    public void 만원_납부하면_한달_뒤가_만료일이_됨() {

        LocalDate billingDate = LocalDate.of(2019, 3, 1);
        int payAmount = 10_000;

        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);

        assertThat(expiryDate).isEqualTo(LocalDate.of(2019, 4, 1));
    }
}

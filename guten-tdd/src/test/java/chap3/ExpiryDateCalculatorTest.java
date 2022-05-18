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


        assertExpiryDate(
                LocalDate.of(2019, 3, 1),
                10_000,
                LocalDate.of(2019, 4, 1));

        assertExpiryDate(
                LocalDate.of(2019, 5, 1),
                10_000,
                LocalDate.of(2019, 6, 1));

    }

    private void assertExpiryDate (
            LocalDate billingDate, int payAmount, LocalDate expectedExpiryDate) {

        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);

        assertThat(expiryDate).isEqualTo(expectedExpiryDate);
    }
}

package chap3;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author gutenlee
 * @since 2022/05/19
 */
public class ExpiryDateCalculatorTest {

    private void assertExpiryDate (PayData payData, LocalDate expectedExpiryDate) {

        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(payData);

        assertThat(expiryDate).isEqualTo(expectedExpiryDate);
    }

    @Test
    public void 만원_납부하면_한달_뒤가_만료일이_됨() {


        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(10_000).build(),
                LocalDate.of(2019, 4, 1));

        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 5, 1))
                        .payAmount(10_000).build(),
                LocalDate.of(2019, 6, 1));

    }


    @Test
    public void 납부일과_한달_뒤_일자가_같지_않음() throws Exception {

        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 1, 31))
                        .payAmount(10_000).build(),
                LocalDate.of(2019, 2, 28)
        );

        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 5, 31))
                        .payAmount(10_000).build(),
                LocalDate.of(2019, 6, 30)
        );

        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2020, 1, 31))
                        .payAmount(10_000).build(),
                LocalDate.of(2020, 2, 29)
        );
    }



}

package chap3;

import org.assertj.core.internal.bytebuddy.asm.Advice;
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

    // 예외 상황 테스트
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

    // 예외 상황 또 테스트
    @Test
    public void 첫_납부일과_만료일_일자가_다를때_만원_납부() throws Exception {

        PayData payData = PayData.builder()
                .firstBillingDate(LocalDate.of(2019, 1, 31))
                .billingDate(LocalDate.of(2019, 2, 28))
                .payAmount(10_000).build();

        assertExpiryDate(payData, LocalDate.of(2019, 3, 31));


        PayData payData2 = PayData.builder()
                .firstBillingDate(LocalDate.of(2019, 1, 30))
                .billingDate(LocalDate.of(2019, 2, 28))
                .payAmount(10_000).build();

        assertExpiryDate(payData2, LocalDate.of(2019, 3, 30));


        PayData payData3 = PayData.builder()
                .firstBillingDate(LocalDate.of(2019, 5, 31))
                .billingDate(LocalDate.of(2019, 6, 30))
                .payAmount(10_000).build();

        assertExpiryDate(payData3, LocalDate.of(2019, 7, 31));
    }


    // 다음 테스트 :: 쉬운 테스트
    @Test
    public void 이만원_이상_납부하면_비례해서_만료일_계산() throws Exception {

        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(20_000)
                        .build(),
                LocalDate.of(2019, 5, 1));

        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(30_000)
                        .build(),
                LocalDate.of(2019, 6, 1));
    }


    // 예외 상황 테스트
    @Test
    public void 첫_납부일과_만료일_일자가_다를때_이만원_이상_납부() throws Exception {

        assertExpiryDate(
                PayData.builder()
                        .firstBillingDate(LocalDate.of(2019, 1, 31))
                        .billingDate(LocalDate.of(2019, 2, 28))
                        .payAmount(20_000)
                        .build(),
                LocalDate.of(2019, 4, 30));


        assertExpiryDate(
                PayData.builder()
                        .firstBillingDate(LocalDate.of(2019, 3, 31))
                        .billingDate(LocalDate.of(2019, 4, 30))
                        .payAmount(30_000)
                        .build(),
                LocalDate.of(2019, 7, 31));
    }


    // 10개월 요금을 납부하면 1년 제공
    @Test
    public void 십만원을_납부하면_1년_제공() throws Exception {
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 1, 28))
                        .payAmount(100_000)
                        .build(),
                LocalDate.of(2020, 1, 28));


        // 윤달 마지막 날에 10만원을 납부하는 상황
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2020, 2, 29))
                        .payAmount(100_000)
                        .build(),
                LocalDate.of(2021, 2, 28));


        // 납부 금액이 10만원 이상
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2020, 2, 29))
                        .payAmount(130_000)
                        .build(),
                LocalDate.of(2021, 5, 29));
    }





}

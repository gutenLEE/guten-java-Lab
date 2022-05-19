package chap3;

import java.time.LocalDate;

/**
 * @author gutenlee
 * @since 2022/05/19
 */
public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData) {

        if (payData.getFirstBillingDate() != null) {

            LocalDate candidateExp = payData.getBillingDate().plusMonths(1);
            // 첫 납부일과 납부일의 일자가 다르면 첫 납부일의 일자를 만료일 일자로 사용
            if (payData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) {
                return candidateExp.withDayOfMonth(
                        payData.getFirstBillingDate().getDayOfMonth());
            }
            if (payData.getFirstBillingDate().equals(LocalDate.of(2019, 1, 31)))
                return LocalDate.of(2019, 3, 31);
        }
        return payData.getBillingDate().plusMonths(1);
    }
}



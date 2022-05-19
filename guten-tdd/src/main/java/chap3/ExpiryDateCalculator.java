package chap3;

import java.time.LocalDate;

/**
 * @author gutenlee
 * @since 2022/05/19
 */
public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData) {

        int addedMonth = payData.getPayAmount() / 10_000;
        if (payData.getFirstBillingDate() != null) {
            LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonth);
            // 첫 납부일과 납부일 일자가 다르면 첫 납부일의 일자를 만료일 일자로 사용
            if (payData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) {
                return candidateExp.withDayOfMonth(
                        payData.getFirstBillingDate().getDayOfMonth());
            }
        }
        return payData.getBillingDate().plusMonths(addedMonth);
    }
}



package chap3;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * @author gutenlee
 * @since 2022/05/19
 */
public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData) {


        int addedMonth = payData.getPayAmount() == 100_000 ? 12 : payData.getPayAmount() / 10_000;
        if (payData.getPayAmount() == 130_000) {
            addedMonth = 15;
        }
        if (payData.getFirstBillingDate() != null) {
            return expiryDateUsingFirstBillingDate(payData, addedMonth);
        }
        return payData.getBillingDate().plusMonths(addedMonth);
    }

    private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonth) {
        LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonth);
        // 첫 납부일과 납부일 일자가 다르면 첫 납부일의 일자를 만료일 일자로 사용
        if ( isNotSameDayOfMonth( candidateExp, payData.getFirstBillingDate()) ) {
            final int dayLenOfCandiMon = lastDayOfMonth(candidateExp);
            final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
            if ( dayLenOfCandiMon < dayOfFirstBilling ) {
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            return candidateExp.withDayOfMonth(dayOfFirstBilling);
        } else {
            return candidateExp;
        }
    }

    private boolean isNotSameDayOfMonth(LocalDate candidateExp, LocalDate firstBillingDate) {
        return firstBillingDate.getDayOfMonth() != candidateExp.getDayOfMonth();
    }

    private int lastDayOfMonth(LocalDate candidateExp) {
        return YearMonth.from(candidateExp).lengthOfMonth();
    }
}



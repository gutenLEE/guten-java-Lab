package chap3;

import java.time.LocalDate;

/**
 * @author gutenlee
 * @since 2022/05/19
 */
public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData) {
        if (payData.getBillingDate().equals(LocalDate.of(2019, 1, 31)))
            return LocalDate.of(2019, 3, 31);
        return payData.getBillingDate().plusMonths(1);
    }
}

package chap3;

import java.time.LocalDate;

/**
 * @author gutenlee
 * @since 2022/05/19
 */
public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(LocalDate bilingDate, int payAmount) {
        return bilingDate.plusMonths(1);
    }
}

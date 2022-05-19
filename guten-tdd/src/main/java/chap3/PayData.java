package chap3;

import java.time.LocalDate;

/**
 * @author gutenlee
 * @since 2022/05/19
 */
public class PayData {

    LocalDate billingDate;
    int payAmount;

    public static Builder builder() {
        return new Builder();
    }

    public PayData() {
    }

    public PayData(LocalDate billingDate, int payAmount) {
        this.billingDate = billingDate;
        this.payAmount = payAmount;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public static class Builder {
        PayData payData = new PayData();

        public Builder billingDate(LocalDate billingDate) {
            payData.billingDate = billingDate;
            return this;
        }

        public Builder payAmount(int payAmount) {
            payData.payAmount = payAmount;
            return this;
        }

        public PayData build() {
            return payData;
        }
    }
}

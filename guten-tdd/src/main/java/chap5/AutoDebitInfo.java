package chap5;

import java.time.LocalDateTime;

/**
 * @author gutenlee
 * @since 2022/05/23
 */
public class AutoDebitInfo {

    private String userId;
    private String cardNumber;
    private LocalDateTime time;

    public AutoDebitInfo(String userId, String cardNumber, LocalDateTime time) {
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.time = time;
    }

    public void changeCardNumber(String cardNumber) {
    }
}

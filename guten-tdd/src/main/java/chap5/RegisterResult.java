package chap5;

/**
 * @author gutenlee
 * @since 2022/05/23
 */
public class RegisterResult {
    public static RegisterResult error(CardValidity validity) {
        return null;
    }

    public static RegisterResult success() {
        return new RegisterResult();
    }

    public CardValidity getValidity() {
        return CardValidity.INVALID;
    }
}

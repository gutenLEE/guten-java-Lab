package chap5;

/**
 * @author gutenlee
 * @since 2022/05/23
 */
public class StubCardNumberValidator extends CardNumberValidator{

    private String invalidNo;

    public void setInvalidNo(String invalidNo) {
        this.invalidNo = invalidNo;
    }

    @Override
    public CardValidity validate(String cardNumber) {
        if (invalidNo != null && invalidNo.equals(cardNumber)) {
            return CardValidity.INVALID;
        }
        return CardValidity.VALID;
    }
}

package chap5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chap5.CardValidity.VALID;
import static org.junit.jupiter.api.Assertions.*;

class AutoDebitRegisterTest {

    private AutoDebitRegister register;

    @BeforeEach
    void setUp() {
        CardNumberValidator validator = new CardNumberValidator();
        AutoDebitRepository repository = new AutoDebitRepository();
        register = new AutoDebitRegister(validator, repository);
    }

    @Test
    void validCard() throws Exception {
        // 업체에서 받은 테스트용 유효한 카드번호 사용
        AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
        DebitRegister result = this.register.register(req);
        assertEquals(VALID, result.getValidity());
    }


}
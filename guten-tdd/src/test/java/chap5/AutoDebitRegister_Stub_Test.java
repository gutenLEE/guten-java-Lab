package chap5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chap5.CardValidity.INVALID;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author gutenlee
 * @since 2022/05/23
 */
public class AutoDebitRegister_Stub_Test {

    private AutoDebitRegister register;
    private StubCardNumberValidator stubValidator;
    private StubAutoDebitRepository repository;

    @BeforeEach
    void setUp() {
        StubCardNumberValidator stubValidator = new StubCardNumberValidator();
        StubAutoDebitRepository stubRepository = new StubAutoDebitRepository();
        AutoDebitRegister register = new AutoDebitRegister(stubValidator, stubRepository);
    }

    @Test
    void invalidCard() throws Exception {
        stubValidator.setInvalidNo("111222333");

        AutoDebitReq req = new AutoDebitReq("user1", "111222333");
        RegisterResult result = this.register.register(req);

        assertEquals(INVALID, result.getValidity());
    }


}

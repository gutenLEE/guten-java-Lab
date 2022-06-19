package chap5;

import chap6.MemoryUserRepository;
import chap6.SpyEmailNotifier;
import chap6.StubWeakPasswordChecker;
import chap6.UserRegister;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chap5.CardValidity.INVALID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author gutenlee
 * @since 2022/05/23
 */
public class AutoDebitRegister_Stub_Test {

    private AutoDebitRegister register;
    private StubCardNumberValidator stubValidator;
    private StubAutoDebitRepository stubRepository;
    private SpyEmailNotifier spyEmailNotifier = new SpyEmailNotifier();
    private UserRegister userRegister;

    @BeforeEach
    void setUp() {
        stubValidator = new StubCardNumberValidator();
        stubRepository = new StubAutoDebitRepository();
        register = new AutoDebitRegister(stubValidator, stubRepository);
        userRegister = new UserRegister(new StubWeakPasswordChecker(), new MemoryUserRepository(), spyEmailNotifier);
    }

    @Test
    void invalidCard() throws Exception {// 상황 - 유효하지 않은 카드 번호
        stubValidator.setInvalidNo("111222333");

        AutoDebitReq req = new AutoDebitReq("user1", "111222333");
        RegisterResult result = this.register.register(req);

        assertEquals(INVALID, result.getValidity());
    }

    @DisplayName("가입하면 메일을 발송함")
    @Test
    void whenRegisterThenSendMail() throws Exception {
        userRegister.register("id", "pw", "email");

        // 결과 확인에 대역 사용
        assertTrue(spyEmailNotifier.isCalled());
        assertEquals("email", spyEmailNotifier.getEmail());
    }




}

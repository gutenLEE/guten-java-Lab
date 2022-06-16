package chap6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author gutenlee
 * @since 2022/06/16
 */
public class UserRegisterMockTest {

    private UserRegister userRegister;
    private WeakPasswordChecker mockPasswordChecker = Mockito.mock(WeakPasswordChecker.class);
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();
    private EmailNotifier mockEmailNotifier = Mockito.mock(EmailNotifier.class); // 인자로 전달받은 타입의 모의 객체 생성

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(mockPasswordChecker, fakeRepository, mockEmailNotifier);
    }

    @Test
    @DisplayName("약한 암호면 가입 실패")
    void weakPassword() throws Exception {

        BDDMockito
                .given(mockPasswordChecker.checkPasswordWeak("pw")) // pw 인자를 사용해서 이 메서드를 호출하면
                .willReturn(true); // true 를 반환해라

        assertThrows(WeakPasswordException.class, () -> {
            userRegister.register("id", "pw", "email");
        });
    }

    @Test
    @DisplayName("회원 가입시 암호 검사 수행함")
    void checkPassword() throws Exception {
         userRegister.register("id", "pw", "email");

         BDDMockito.then(mockPasswordChecker)
                 .should() // 특정 메서드가 호출됐는지 검증
                 .checkPasswordWeak(BDDMockito.anyString()); // 스트링 타입 인자를 이요해서 이 메서드 호출 여부를 확인
    }

    @Test
    @DisplayName("가입하면 메일을 전송함")
    void whenRegisterThenSendEmail() throws Exception {

         userRegister.register("id", "pw", "email@naver.com");

         // 메서드를 호출할 때 전달한 객체를 담는 기능
         ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
         BDDMockito.then(mockEmailNotifier)
                 .should()
                 .sendRegisterEmail(captor.capture());

        String realEmail = captor.getValue();
        assertEquals("email@naver.com", realEmail);
    }






}

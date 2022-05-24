package chap6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author gutenlee
 * @since 2022/05/25
 */
public class UserRegisterTest {

    private UserRegister userRegister;
    private StubWeakPasswordChecker stubWeakPasswordChecker = new StubWeakPasswordChecker(); // 대역

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(stubWeakPasswordChecker);
    }


    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword() throws Exception {

         stubWeakPasswordChecker.setWeak(true);

         assertThrows(WeakPasswordException.class, () -> {
             userRegister.register("id", "pw", "email");
         });
    }


}

package chap6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author gutenlee
 * @since 2022/05/25
 */
public class UserRegisterTest {

    private UserRegister userRegister;
    private StubWeakPasswordChecker stubWeakPasswordChecker = new StubWeakPasswordChecker(); // 대역
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(stubWeakPasswordChecker, fakeRepository);
    }


    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword() throws Exception {

         stubWeakPasswordChecker.setWeak(true);

         assertThrows(WeakPasswordException.class, () -> {
             userRegister.register("id", "pw", "email");
         });
    }

    @Test
    @DisplayName("이미 같은 ID가 존재하면 가입 실패")
    void dupIdExists() throws Exception {
         // 이미 같은 아이디가 존재하는 상황 만들기
        fakeRepository.save(new User("id", "pw1", "email@email.com"));
        assertThrows(DupIdException.class, () -> {
            userRegister.register("id", "pw2", "email");
        });
    }

    @Test
    @DisplayName("같은 id가 없으면 가입 성공함")
    void noDupId_register_success() throws Exception {

        userRegister.register("id", "pw", "email");

        User user = fakeRepository.findById("id");

        assertEquals("id", user.getId());
        assertEquals("email", user.getEmail());

    }






}

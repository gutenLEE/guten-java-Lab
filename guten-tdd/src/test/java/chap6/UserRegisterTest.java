package chap6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author gutenlee
 * @since 2022/05/25
 */
public class  UserRegisterTest {

    private UserRegister userRegister;
    private StubWeakPasswordChecker stubWeakPasswordChecker = new StubWeakPasswordChecker(); // 대역
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();
    private SpyEmailNotifier emailNotifier = new SpyEmailNotifier();

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(stubWeakPasswordChecker, fakeRepository, emailNotifier);
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

    @Test
    @DisplayName("가입에 성공하면 이메일 발송함")
    void if_register_success_email_send() throws Exception {

         // 이메일이 발송되었는지 검증? 이메일 주소로 USER의 email 값을 사용했는지 확인 -> 스파이 대역 활용
        userRegister.register("id", "pw", "email@email.com");

        assertTrue(emailNotifier.isCalled());
        assertEquals("email@email.com", emailNotifier.getEmail());
    }








}

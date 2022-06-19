package chap6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author gutenlee
 * @since 2022/06/20
 */
public class UserRegisterMockOvercaseTest {
    private UserRegister userRegister;
    private UserRepository mockRepository = Mockito.mock(UserRepository.class);

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(new StubWeakPasswordChecker(), new MemoryUserRepository(), new SpyEmailNotifier());
    }

    @Test
    void noDupId_RegisterSuccess() throws Exception {
         userRegister.register("id", "pw", "email");

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        BDDMockito.then(mockRepository).should().save(captor.capture());

        User savedUser = captor.getValue();
        assertEquals("id", savedUser.getId());
        assertEquals("email", savedUser.getEmail());
    }

    @Test
    void 같은_id_없으면_가입() throws Exception {
        // 코드가 위 케이스보다 단순해짐. 코드의 의미도 더 명확함
        userRegister.register("id", "pw", "email");

        User savedUser = mockRepository.findById("id");
        assertEquals("id", savedUser.getId());
        assertEquals("email", savedUser.getEmail());
    }




}

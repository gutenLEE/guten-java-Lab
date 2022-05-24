package chap6;

/**
 * @author gutenlee
 * @since 2022/05/25
 */
public class UserRegister {

    private WeakPasswordChecker weakPasswordChecker;

    public UserRegister(WeakPasswordChecker weakPasswordChecker, MemoryUserRepository fakeRepository) {
        this.weakPasswordChecker = weakPasswordChecker;
    }

    public void register(String id, String pw, String email) throws WeakPasswordException, DupIdException {
        if (weakPasswordChecker.checkPasswordWeak(pw))
            throw new WeakPasswordException();

        throw new DupIdException();
    }
}

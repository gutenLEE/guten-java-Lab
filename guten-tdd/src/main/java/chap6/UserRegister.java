package chap6;

/**
 * @author gutenlee
 * @since 2022/05/25
 */
public class UserRegister {

    private WeakPasswordChecker weakPasswordChecker;
    private UserRepository userRepository;
    private EmailNotifier emailNotifier;

    public UserRegister(WeakPasswordChecker weakPasswordChecker, UserRepository fakeRepository, EmailNotifier emailNotifier) {
        this.weakPasswordChecker = weakPasswordChecker;
        this.userRepository = fakeRepository;
        this.emailNotifier = emailNotifier;
    }



    public void register(String id, String pw, String email) throws WeakPasswordException, DupIdException {

        if (weakPasswordChecker.checkPasswordWeak(pw))
            throw new WeakPasswordException();
            User user = userRepository.findById(id);
        if (user != null) {
            throw new DupIdException();

        }
        userRepository.save(new User(id, pw, email));

        emailNotifier.sendRegisterEmail(email);
    }
}

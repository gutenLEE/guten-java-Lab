package chap6;

/**
 * @author gutenlee
 * @since 2022/05/25
 */
public class StubWeakPasswordChecker implements WeakPasswordChecker{

    private boolean weak;

    public void setWeak(boolean weak) {
        this.weak = weak;
    }

    @Override
    public boolean checkPasswordWeak(String pw) {
        return weak;
    }
}

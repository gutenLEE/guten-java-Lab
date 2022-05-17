package chap2;

/**
 * @author yhlee
 * @since 2022-05-17 오전 8:46
 */
public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {

        if ( s == null || s.isEmpty() ) return PasswordStrength.INVALID;

        boolean lengthEnough = s.length() >= 8;

        if (!lengthEnough) {
            return PasswordStrength.NORMAL;
        }

        boolean containsNum = false;
        containsNum = meetsContainingNumberCriteria(s);
        if ( !containsNum ) return PasswordStrength.NORMAL;

        boolean containsUpp = false;
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch))
                containsUpp = true;
        }
        if ( !containsUpp ) return PasswordStrength.NORMAL;

        return PasswordStrength.STRONG;
    }

    private boolean meetsContainingNumberCriteria(String s) {
        boolean containsNum = false;
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                containsNum = true;
                break;
            }
        }
        return containsNum;
    }
}

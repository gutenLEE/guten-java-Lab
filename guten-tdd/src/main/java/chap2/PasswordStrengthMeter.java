package chap2;

/**
 * @author yhlee
 * @since 2022-05-17 오전 8:46
 */
public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {

        if ( s == null || s.isEmpty() ) return PasswordStrength.INVALID;

        boolean lengthEnough = s.length() >= 8;
        boolean containsNum = meetsContainingNumberCriteria(s);
        boolean containsUpp = meetsContainingUppercaseCritera(s);

        if (lengthEnough && !containsNum && !containsUpp)
            return PasswordStrength.WEAK;

        if (!lengthEnough) {
            return PasswordStrength.NORMAL;
        }
        if ( !containsNum ) return PasswordStrength.NORMAL;
        if ( !containsUpp ) return PasswordStrength.NORMAL;

        return PasswordStrength.STRONG;
    }

    private boolean meetsContainingUppercaseCritera(String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch))
                return true;
        }
        return false;
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

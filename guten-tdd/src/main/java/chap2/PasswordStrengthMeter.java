package chap2;

/**
 * @author yhlee
 * @since 2022-05-17 오전 8:46
 */
public class PasswordStrengthMeter {

    public PasswordStrength meter(String s) {

        if ( s == null || s.isEmpty() ) return PasswordStrength.INVALID;

        int meetsCount = getMetCriteriaCounts(s);
        // 아래 코드는 1개의 조건을 충족하면 강도가 약함이라는 규칙을 더 잘 표현해줌.
        if (meetsCount <= 1) return PasswordStrength.WEAK;
        if (meetsCount == 2) return PasswordStrength.NORMAL;

        return PasswordStrength.STRONG;
    }

    private int getMetCriteriaCounts(String s) {
        int meetsCount = 0;
        if (s.length() >= 8) meetsCount++;
        if (meetsContainingNumberCriteria(s)) meetsCount++;
        if (meetsContainingUppercaseCritera(s)) meetsCount++;
        return meetsCount;
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


    private boolean meetsContainingUppercaseCritera(String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch))
                return true;
        }
        return false;
    }

}

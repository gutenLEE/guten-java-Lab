package algorithm;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author gutenlee
 * @since 2022/06/06
 */
public class Kakao_Sorting_fileName {

    // 1. split the file name into head, number, tail

    @Test
    void test() throws Exception {

        assertSplit("foo9.txt","foo", "9", ".txt");
        assertSplit("foo010bar020.zip","foo", "010", "bar020.zip");
    }

    private void assertSplit(String str, String head, String number, String tail) {
        String[] split = str.split("\\.");

        StringBuilder aHead = new StringBuilder("");
        StringBuilder aNum = new StringBuilder("");
        StringBuilder aTail = new StringBuilder("");

        int from = 0;
        int to = 0;
        for (int i = 0; i < str.split("").length; i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)){
                from = i;
                break;
            }
            aHead.append(String.valueOf(c));
        }

        for (int i = from; i < str.split("").length; i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)){
                to = i;
                break;
            }
            aNum.append(String.valueOf(c));
        }

        for (int i = to; i < str.split("").length; i++) {
            char c = str.charAt(i);
            aTail.append(String.valueOf(c));
        }

        assertThat(aHead.toString()).isEqualTo(head);
        assertThat(aNum.toString()).isEqualTo(number);
        assertThat(aTail.toString()).isEqualTo(tail);

    }

}

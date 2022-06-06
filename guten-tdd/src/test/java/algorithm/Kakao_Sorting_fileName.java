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
        assertSplit("F-15","F-", "15", "");
        assertSplit("F-5 Freedom Fighter","F-", "5", " Freedom Fighter");
        assertSplit("MG01.GIF","MG", "01", ".GIF");
    }

    private void assertSplit(String str, String head, String number, String tail) {

        String[] arr = splitFileName(str);

        assertThat(arr[0]).isEqualTo(head);
        assertThat(arr[1]).isEqualTo(number);
        assertThat(arr[2]).isEqualTo(tail);

    }

    private String[] splitFileName(String str) {
        StringBuilder aHead = new StringBuilder("");
        StringBuilder aNum = new StringBuilder("");
        StringBuilder aTail = new StringBuilder("");

        int length = str.split("").length;
        int from = 0;
        int to = length;
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)){
                from = i;
                break;
            }
            aHead.append(String.valueOf(c));
        }

        for (int i = from; i < length; i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)){
                to = i;
                break;
            }
            aNum.append(String.valueOf(c));
        }

        if (!(to == length)){
            for (int i = to; i < length; i++) {
                char c = str.charAt(i);
                aTail.append(String.valueOf(c));
            }
        }
        return new String[]{aHead.toString(), aNum.toString(), aTail.toString()};
    }

}

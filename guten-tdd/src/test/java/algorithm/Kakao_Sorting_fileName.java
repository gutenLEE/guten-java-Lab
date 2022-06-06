package algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author gutenlee
 * @since 2022/06/06
 */
public class Kakao_Sorting_fileName {

    // 1. split the file name into head, number, tail

    @Test
    void split_filename_result_should_be_3_length_of_array() throws Exception {

        assertSplit("foo9.txt","foo", "9", ".txt");
        assertSplit("foo010bar020.zip","foo", "010", "bar020.zip");
        assertSplit("F-15","F-", "15", "");
        assertSplit("F-5 Freedom Fighter","F-", "5", " Freedom Fighter");
        assertSplit("MG01.GIF","MG", "01", ".GIF");
    }

    @Test
    void sorting_test() throws Exception {
        assertSorting(List.of("img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"),
                        List.of("img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"));

        assertSorting(List.of("F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"),
                        List.of("A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"));
    }

    private void assertSorting(List<String> caseList, List<String> expected){
        List<String[]> arrList = new ArrayList<>();
        for (String str : caseList) {
            String[] arr = splitFileName(str);
            arrList.add(arr);
        }
        List<String[]> results = arrList.stream()
                .sorted(Comparator.<String[], String>comparing(arr -> arr[0].toLowerCase(Locale.ROOT))
                        .thenComparing(arr2 -> Integer.parseInt(arr2[1])))
                .collect(Collectors.toList());

        List<String> actual = new ArrayList<>(caseList.size());
        results.forEach(arr -> {
            StringBuilder sb = new StringBuilder("");
            for (String s : arr) {
                sb.append(s);
            }
            actual.add(sb.toString());
            System.out.println("sb.toString() = " + sb.toString());
        });
        assertThat(actual).isEqualTo(expected);
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

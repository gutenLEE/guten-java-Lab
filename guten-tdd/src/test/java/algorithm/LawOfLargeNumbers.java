package algorithm;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import scala.Int;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 큰수의 법칙
 * @author gutenlee
 * @since 2022/08/16
 */
public class LawOfLargeNumbers {

    @Test
    void test() throws Exception {
        // input - N : size of array, M : m번 더하기, K : 연속해서 k번 까지만 더할 수 있음
        assertThat(add(new Integer[]{2, 4, 5, 3, 6}, 8, 3)).isEqualTo(46);
        // 예외
        assertThat(add(new Integer[]{2, 4, 5, 3, 6}, 0, 3)).isEqualTo(0);

    }

    private int add(Integer[] array, int totalCount, int limitCount){
        int sum = 0;
        Arrays.sort(array, Collections.reverseOrder());

        int firstMax = array[0];
        int secondMax = array[1];

        while (totalCount != 0) {
            sum += (firstMax*limitCount);
            sum += (secondMax);
            totalCount -= (limitCount+1);
        }

        return sum;
    }


}

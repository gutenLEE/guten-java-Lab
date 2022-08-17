package algorithm;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import scala.Int;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.from;

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

        // totalCount -= (limitCount+1), totalCount != 0 예외 발생
        assertThat(add(new Integer[]{2, 4, 5, 3, 6}, 8, 2)).isEqualTo(46);

    }

    private int add(Integer[] array, int totalCount, int limitCount){
        int sum = 0;
        Arrays.sort(array, Collections.reverseOrder());

        int firstMax = array[0];
        int secondMax = array[1];


        int firstMaxCount = totalCount / (limitCount+1) * limitCount;
        firstMaxCount += (totalCount % (limitCount+1));

        int secondMaxCount = totalCount - firstMaxCount;

        sum = (firstMax * firstMaxCount) + (secondMax * secondMaxCount);
        return sum;
    }


}

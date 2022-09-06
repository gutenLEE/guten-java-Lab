package algorithm.greedy;

import algorithm.greedy.MinMaker;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://www.acmicpc.net/problem/1026
 *
 * @author gutenlee
 * @since 2022/09/05
 */
public class TreasureTest {
    @Test
    void sort_test() throws Exception {
        MinMaker minMaker = new MinMaker(Arrays.asList(1, 4, 3, 2, 5), Arrays.asList(4, 6, 3, 1, 3));
        assertThat(minMaker.getA()).containsExactly(1, 2, 3, 4, 5);
        assertThat(minMaker.getB()).containsExactly(4, 6, 3, 1, 3);
    }


    @Test
    void result_test() throws Exception {
        MinMaker minMaker = new MinMaker(Arrays.asList(1, 1, 1, 6, 0), Arrays.asList(2, 7, 8, 3, 1));
        assertThat(minMaker.getResultOfMinimumCombination()).isEqualTo(18);

    }



}

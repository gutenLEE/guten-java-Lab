package algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author gutenlee
 * @since 2022/08/18
 */
public class TillOneTest {
    // input - N
    // loop until N to 1
    // output - the minimum number of operation
    @Test
    void test() throws Exception {
         assertThat(operationCycleCount(25, 5)).isEqualTo(2);
         assertThat(operationCycleCount(17, 4)).isEqualTo(3);
    }

    private int operationCycleCount(int n, int k){
        // 1. N - 1
        // 2. N / K

        // 나누는게 가장 좋음.
        int cycle = 0;
        while (n != 1) {
            if (n%k == 0) {
                n = divide(n, k);
                cycle++;
            } else {
                n = minus(n);
                cycle++;
            }
        }
        return cycle;
    }

    private int minus(int n) {
        return n - 1;
    }

    private int divide(int n, int k) {
        return n / k;
    }

}

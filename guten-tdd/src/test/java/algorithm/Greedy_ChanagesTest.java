package algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author gutenlee
 * @since 2022/08/09
 */
public class Greedy_ChanagesTest {
    // 500, 100, 50, 10
    // input : N 원 (10의 배수)
    // output : 거스름돈의 최소 동전의 개수

    @Test
    void test() throws Exception {
         assertThat(getAnswer(500)).isEqualTo(1);
         assertThat(getAnswer(550)).isEqualTo(2);
         assertThat(getAnswer(600)).isEqualTo(2);
         assertThat(getAnswer(50)).isEqualTo(1);
         assertThat(getAnswer(30)).isEqualTo(3);
    }



    public static int getAnswer(int n){
        int answer = 0;

        int[] coins = new int[4];
        coins[0] = 500;
        coins[1] = 100;
        coins[2] = 50;
        coins[3] = 10;

        // 순차적으로 가장 큰 동전부터 차감
        for (var coin : coins) {
            if (n == 0) break;

            if (n >= coin){
                answer += n / coin;
                n = n % coin;
            }
        }
        return answer;
    }
}

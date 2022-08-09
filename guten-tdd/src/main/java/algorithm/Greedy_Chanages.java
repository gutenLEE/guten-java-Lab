package algorithm;

/**
 * @author gutenlee
 * @since 2022/08/09
 */
public class Greedy_Chanages {
    // 500, 100, 50, 10
    // input : N 원 (10의 배수)
    // output : 거스름돈의 최소 동전의 개수

    public static void main(String[] args) {
        int answer = getAnswer(500);
    }

    public static int getAnswer(int n){
        int answer = 0;

        int[] coins = new int[4];
        coins[0] = 500;
        coins[1] = 100;
        coins[2] = 50;
        coins[3] = 10;

        for (var coin : coins) {
            if (n >= coin){
                answer = n / coin;
                n = n % coin;
            }
            if (n == 0) break;
        }
        return answer;
    }
}

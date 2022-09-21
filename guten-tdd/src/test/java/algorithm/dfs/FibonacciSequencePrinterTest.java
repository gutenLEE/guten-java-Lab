package algorithm.dfs;

import org.junit.jupiter.api.Test;

/**
 * @author gutenlee
 * @since 2022/09/21
 */
public class FibonacciSequencePrinterTest {
    // 피보나치 수열 출력하라
    // input - 총 항의 수
    static int[] fibo;
    @Test
    void test() throws Exception {
        int n = 45;
        fibo = new int[n+1];
        dfs(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }

    private int dfs(int n){
        if (fibo[n]>0) return fibo[n];
       if (n==1)return fibo[n]=1;
       if (n==2)return fibo[n]=1;

       return fibo[n]=dfs(n-2)+dfs(n-1);
    }


}

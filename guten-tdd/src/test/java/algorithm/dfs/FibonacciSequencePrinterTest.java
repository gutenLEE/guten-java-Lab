package algorithm.dfs;

import org.junit.jupiter.api.Test;

/**
 * @author gutenlee
 * @since 2022/09/21
 */
public class FibonacciSequencePrinterTest {
    // 피보나치 수열 출력하라
    // input - 총 항의 수
    @Test
    void test() throws Exception {
        System.out.println(dfs(7));
    }

    private int dfs(int n){
       if (n==1)return 1;
       if (n==2)return 1;

       return dfs(n-2)+dfs(n-1);
    }


}
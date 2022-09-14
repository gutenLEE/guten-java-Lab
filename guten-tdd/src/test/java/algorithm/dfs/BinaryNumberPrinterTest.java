package algorithm.dfs;

import org.junit.jupiter.api.Test;

/**
 * @author gutenlee
 * @since 2022/09/14
 */
public class BinaryNumberPrinterTest {

    // 10진수 n이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하시오.

    @Test
    void test() throws Exception {
        dfs(11);
        dfs(34);
    }

    private void dfs(int n) {
        if (n == 0)
            return;
        dfs(n/2);
        System.out.print(n%2);
    }

}

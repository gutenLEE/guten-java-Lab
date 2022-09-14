package algorithm.dfs;

import org.junit.jupiter.api.Test;

/**
 * @author gutenlee
 * @since 2022/09/14
 */
public class NumberPrinterTest {

    @Test
    void printTest() throws Exception {
        print(3);
    }

    private void print(int n){
        if (n == 0)
            return;
        print(n - 1);
        System.out.print(n);
        System.out.print(" ");
    }


}

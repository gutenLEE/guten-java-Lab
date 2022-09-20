package algorithm.dfs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author gutenlee
 * @since 2022/09/20
 */
public class FactorialTest {
    @Test
    void test() throws Exception {
        int dfs = dfs(5);
        assertThat(dfs).isEqualTo(120);
    }

    private int dfs(int value){
        if (value == 0) return 1;
        return value * dfs(value-1);
    }
}

package algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author gutenlee
 * @since 2022/05/18
 */
public class FirstBadVersionTest {

    int[] indexs = new int[103];

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 103; i++) {
            indexs[i] = i;
        }
    }

    @Test
    void name() throws Exception {
        int n = indexs.length;
        assertThat(n).isEqualTo(103);

        int mid = n / 2;
        int start = 0;


    }


}

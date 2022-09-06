package algorithm.dfs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * 이것이 코딩테스트다 - 음료수 얼려 먹기
 * @author gutenlee
 * @since 2022/09/06
 */
public class FreezeCokeTest {

    int[][] iceFrame;

    @BeforeEach
    void setUp() {
        iceFrame = new int[4][4];
        iceFrame[0] = new int[]{0,0,1,1,0};
        iceFrame[1] = new int[]{0,0,0,1,1};
        iceFrame[2] = new int[]{1,1,1,1,1};
        iceFrame[3] = new int[]{0,0,0,0,0};
    }

    @Test
    void test() throws Exception {
        int result = 0;
        for (int i = 0; i < iceFrame.length; i++) {
            for (int j = 0; j < iceFrame[0].length; j++) {
                if (dfs(i, j))
                    result++;
            }
        }

        assertEquals(3, result);
    }

    public boolean dfs(int x, int y) {
        if (x <= -1 || x >= iceFrame.length || y <= -1 || y >= iceFrame[0].length)
            return false;
        if (iceFrame[x][y] == 0){
            iceFrame[x][y] = 1;
            dfs(x-1, y);
            dfs(x+1, y);
            dfs(x,y-1);
            dfs(x,y+1);
            return true;
        }
        return false;
    }

}

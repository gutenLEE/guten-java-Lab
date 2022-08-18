package algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author gutenlee
 * @since 2022/08/18
 */
public class CardGameTest {
    // input N x M
    // 행 선택, 가장 낮은 숫자가 선택됨.
    // output  선택한 행에서 리턴되는 숫자가 가장 크도록
    @Test
    void test() throws Exception {

        int[][] matrix = new int[3][3];
        matrix[0][0] = 3; matrix[1][0] = 4; matrix[2][0] = 2;
        matrix[0][1] = 1; matrix[1][1] = 1; matrix[2][1] = 2;
        matrix[0][2] = 2; matrix[1][2] = 4; matrix[2][2] = 2;

        assertThat(selectRow(matrix)).isEqualTo(2);

        matrix = new int[2][4];
        matrix[0][0] = 7; matrix[0][1] = 3; matrix[0][2] = 1; matrix[0][3] = 8;
        matrix[1][0] = 3; matrix[1][1] = 3; matrix[1][2] = 3; matrix[1][3] = 4;

        assertThat(selectRow(matrix)).isEqualTo(3);

    }


    private int selectRow(int[][] cardMatrix) {

        int rows = cardMatrix.length;
        int cols = cardMatrix[0].length;

        int std = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            int[] row = cardMatrix[i];
            Arrays.sort(row);
            int min = row[0];
            if (min > std)
                std = min;
        }

        return std;
    }
}

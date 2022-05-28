package algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.STRING_BUFFER;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/67256
 *
 * @author gutenlee
 * @since 2022/05/27
 */
public class KakaoCodingTest_KeypadTest {

    @Test
    void x_pos_test() throws Exception {

        assertThat((1-1) / 3).isEqualTo(0);
        assertThat((2-1) / 3).isEqualTo(0);
        assertThat((3-1) / 3).isEqualTo(0);

        assertThat((4-1) / 3).isEqualTo(1);
        assertThat((5-1) / 3).isEqualTo(1);
        assertThat((6-1) / 3).isEqualTo(1);

        assertThat((7-1) / 3).isEqualTo(2);
        assertThat((8-1) / 3).isEqualTo(2);
        assertThat((9-1) / 3).isEqualTo(2);

    }

    @Test
    void y_pos_test() throws Exception {
        assertThat((1-1) % 3).isEqualTo(0);
        assertThat((2-1) % 3).isEqualTo(1);
        assertThat((3-1) % 3).isEqualTo(2);

        assertThat((4-1) % 3).isEqualTo(0);
        assertThat((5-1) % 3).isEqualTo(1);
        assertThat((6-1) % 3).isEqualTo(2);

        assertThat((7-1) % 3).isEqualTo(0);
        assertThat((8-1) % 3).isEqualTo(1);
        assertThat((9-1) % 3).isEqualTo(2);
    }

    @Test
    void pos_test() throws Exception {

        assertPosition(1, 0, 0);
        assertPosition(2, 0, 1);
        assertPosition(3, 0, 2);

        assertPosition(4, 1, 0);
        assertPosition(5, 1, 1);
        assertPosition(6, 1, 2);

        assertPosition(7, 2, 0);
        assertPosition(8, 2, 1);
        assertPosition(9, 2, 2);

        // 예외 0
        assertPosition(0, 3, 1);
    }

    private void assertPosition(int target, int expectedX, int expectedY) {
        int x = (target - 1) / 3;
        int y = (target - 1) % 3;

        if (target == 0){
            x = 3;
            y = 1;
        }

        assertThat(x).isEqualTo(expectedX);
        assertThat(y).isEqualTo(expectedY);
    }


    @Test
    void sheet() throws Exception {

        int[] inputs = new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        assertThat(getResult(inputs, "right")).isEqualTo("LRLLLRLLRRL");

        // 예외) 7 -> 8 vs 0 -> 8
        //      0
        int[] inputs_2 = new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        assertThat(getResult(inputs_2, "left")).isEqualTo("LRLLRRLLLRR");

        int[] inputs_3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        assertThat(getResult(inputs_3, "right")).isEqualTo("LLRLLRLLRL");
    }

    private String getResult(int[] inputs, String hand) {
        int[] left =  new int[]{3, 0};
        int[] right =  new int[]{3, 2};
        StringBuilder sb = new StringBuilder("");

        for (int num : inputs) {
            int x, y;
            if (num == 0){
                x = 3;
                y = 1;
            } else {
                x = (num-1) / 3;
                y = (num-1) % 3;
            }

            if (isFirstColumn(y)) {
                sb.append("L");
                setPosition(left, x, y);
                continue;
            }
            if (isThirdColumn(y)) {
                sb.append("R");
                setPosition(right, x, y);
                continue;
            }
            int leftHandMoveCount = abs(left[0] - x) + abs(left[1] - y);
            int rightHandMoveCount = abs(right[0] - x) + abs(right[1] - y);

            if (leftHandMoveCount == rightHandMoveCount) {
                if ("right".equals(hand)) {
                    sb.append("R");
                    setPosition(right, x, y);
                } else {
                    sb.append("L");
                    setPosition(left, x, y);
                }
            }
            else if (leftHandMoveCount > rightHandMoveCount){
                sb.append("R");
                setPosition(right, x, y);
            } else {
                sb.append("L");
                setPosition(left, x, y);
            }
        }
        return sb.toString();
    }

    private boolean isThirdColumn(int y) {
        return y == 2;
    }

    private boolean isFirstColumn(int y) {
        return y == 0;
    }

    private void setPosition(int[] position, int x, int y){
        position[0] = x;
        position[1] = y;
    }






}

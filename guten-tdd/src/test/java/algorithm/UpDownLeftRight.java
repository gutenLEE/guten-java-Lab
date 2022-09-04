package algorithm;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;
import static org.assertj.core.api.InstanceOfAssertFactories.atomicStampedReference;

/**
 * @author gutenlee
 * @since 2022/08/22
 */
public class UpDownLeftRight {

    // input - N : 칸의 개수
    // logic - L, U, R, D 이동 방향
    // output - 도착 지점의 좌표 x, y

    private Move move;

    @BeforeEach
    void setUp() {
        move = new Move();
    }

    @Test
    void make_map() throws Exception {

        assertThat(directions("R R R U D D")).contains("R", "R", "R", "U", "D", "D");
        String[] directions = directions("R R R U D D");

        int[] finalPosition = getFinalPosition(directions);
        assertThat(finalPosition[0]).isEqualTo(3);
        assertThat(finalPosition[1]).isEqualTo(4);
    }


    @Test
    void right() throws Exception {
        move.goTo("R");
        assertThat(move.getX()).isEqualTo(0);
        assertThat(move.getY()).isEqualTo(1);
    }

    @Test
    void left() throws Exception {
        move.goTo("L");
        assertThat(move.getX()).isEqualTo(0);
        assertThat(move.getY()).isEqualTo(-1);
    }

    @Test
    void up() throws Exception {
        move.goTo("U");
        assertThat(move.getX()).isEqualTo(-1);
        assertThat(move.getY()).isEqualTo(0);
    }

    @Test
    void down() throws Exception {
        move.goTo("D");
        assertThat(move.getX()).isEqualTo(1);
        assertThat(move.getY()).isEqualTo(0);
    }









    private int[] getFinalPosition(String[] directions) {
        int upBoundary = 0;
        int downBoundary = directions.length -1;
        int leftBoundary = 0;
        int rightBoundary = directions[0].length() -1;

        int startY = 0;
        int startX = 0;

        int curX = startX;

        int curY = startY;
        for (int i = 0; i < directions.length; i++) {
            String direction = directions[i];
            int curPos = 0;
            switch (direction) {
                case "U":
                    curPos = curX--;
                    if (curPos > upBoundary) {
                        curX += curPos;
                    }
                    break;
                case "D":
                    curPos = curX++;
                    if (curPos < downBoundary) {
                        curX += curPos;
                    }
                    break;
                case "R":
                    curPos = curY++;
                    if (curPos < rightBoundary){
                        curY += curPos;
                    }
                    break;
                case "L":
                    curPos = curY--;
                    if (curPos > leftBoundary) {
                        curY += curPos;
                    }
                    break;
            }
            if (i == directions.length - 1) {
                return new int[]{curX+1, curY+1};
            }
        }

        return new int[]{-1, -1};
    }

    private String[] directions(String str){
        return str.split(" ");
    }

}

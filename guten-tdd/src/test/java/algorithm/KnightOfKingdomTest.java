package algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 이것이 코딩테스트다 - 왕실의 나이트 115p
 * @author gutenlee
 * @since 2022/09/04
 */
public class KnightOfKingdomTest {
    /**
     * 좌표 8X8에서 좌표가 주어졌을 때 나이트가 이동할 수 있는 경우의 수를 구하시오
     *
     * - 좌표 변환
     * - 이동 기능
     *   1. 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동
     *   1-1. 이동할 수 없는 위치에 있는 경우
     *   2. 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동
     *   2-1. 이동할 수 없는 위치에 있는 경우
     * 이동할 수 있는 경우의 수 계산 기능
     */

    @Test
    void position_translate() throws Exception {
        Chessboard chessboard = new Chessboard("a1");
        assertThat(chessboard.getX()).isEqualTo(1);
        assertThat(chessboard.getY()).isEqualTo(1);

        chessboard = new Chessboard("h1");
        assertThat(chessboard.getX()).isEqualTo(1);
        assertThat(chessboard.getY()).isEqualTo(8);
    }

    @Test
    void move_to_right_possible() throws Exception {
        Chessboard chessboard = new Chessboard("a1");
        assertThat(chessboard.movableRight()).isTrue();
    }

    @Test
    void move_to_right_impossible() throws Exception {
        Chessboard chessboard = new Chessboard("h1");
        assertThat(chessboard.movableRight()).isFalse();
    }

    @Test
    void move_to_left() throws Exception {
        Chessboard chessboard = new Chessboard("c1");
        assertThat(chessboard.movableLeft()).isTrue();

        chessboard = new Chessboard("b1");
        assertThat(chessboard.movableLeft()).isFalse();
    }

    @Test
    void move_to_up() throws Exception {
        Chessboard chessboard = new Chessboard("c3");
        assertThat(chessboard.movableUp()).isTrue();

        chessboard = new Chessboard("b2");
        assertThat(chessboard.movableUp()).isFalse();
    }
    
    @Test
    void move_to_down_possible() throws Exception {
        Chessboard chessboard = new Chessboard("a1");
        assertThat(chessboard.movableDown()).isTrue();
    }

    @Test
    void move_to_down_impossible() throws Exception {
        Chessboard chessboard = new Chessboard("a8");
        assertThat(chessboard.movableDown()).isFalse();
    }

    @Test 
    void get_number_of_cases() throws Exception {
        Chessboard chessboard = new Chessboard("a1");
        assertThat(chessboard.getMovableCount()).isEqualTo(2);

        chessboard = new Chessboard("d6");
        assertThat(chessboard.getMovableCount()).isEqualTo(8);

        chessboard = new Chessboard("c2");
        assertThat(chessboard.getMovableCount()).isEqualTo(6);
    }
}

package algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

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
        move = new Move(3);
    }

    @Test
    void make_map() throws Exception {

        assertThat(directions("R R R U D D")).contains("R", "R", "R", "U", "D", "D");
        String[] directions = directions("R R R U D D");

        Move move = new Move(5);
        for (String direction : directions) {
            move.goTo(direction);
        }
        assertThat(move.getX()).isEqualTo(3);
        assertThat(move.getY()).isEqualTo(4);
    }

    @Test
    void right() throws Exception {
        for (int i = 1; i <= 4; i++) {
            move.goTo("R");
        }
        assertThat(move.getX()).isEqualTo(0);
        assertThat(move.getY()).isEqualTo(3);
    }

    @Test
    void left() throws Exception {
        assertThat(move.getX()).isEqualTo(0);
        assertThat(move.getY()).isEqualTo(0);
    }

    @Test
    void up() throws Exception {
        move.goTo("U");
        assertThat(move.getX()).isEqualTo(0);
        assertThat(move.getY()).isEqualTo(0);
    }

    @Test
    void down() throws Exception {
        for (int i = 1; i <= 4; i++) {
            move.goTo("D");
        }
        assertThat(move.getX()).isEqualTo(3);
        assertThat(move.getY()).isEqualTo(0);
    }

    private String[] directions(String str){
        return str.split(" ");
    }

}

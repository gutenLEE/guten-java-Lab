package algorithm;

import org.junit.jupiter.api.Test;

import static algorithm.DIRECTION.getDirection;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author gutenlee
 * @since 2022/09/06
 */
public class DevelopGameTest {

    @Test
    void direction_test() throws Exception {
        assertThat(getDirection(1)).isEqualTo(DIRECTION.EAST);
        assertThat(getDirection(2)).isEqualTo(DIRECTION.SOUTH);
        assertThat(getDirection(3)).isEqualTo(DIRECTION.WEST);
        assertThat(getDirection(0)).isEqualTo(DIRECTION.NORTH);
    }

    @Test
    void land_test() throws Exception {
        assertThat(MAP.getLand(0)).isEqualTo(MAP.LAND);
        assertThat(MAP.getLand(1)).isEqualTo(MAP.SEA);
    }

    // 가보지 않은 칸 - 왼쪽방향으로 회전, 왼쪽으로 한 칸 전진
    // 가본 칸 - 왼쪽 방향으로 회전만 수행하고 1단계로 돌아간다
    // 4면 모두 가본칸 - 방향 유지, 뒤로 한 칸 이동 / 바다면 이동 금지
    @Test
    void turn_left_90_degree() throws Exception {
        // 현재 방향 -> 왼쪽 90도 회전은 direction - 1
        assertThat(getDirection(3).turnLeft()).isEqualTo(DIRECTION.SOUTH);
        assertThat(getDirection(2).turnLeft()).isEqualTo(DIRECTION.EAST);
        assertThat(getDirection(1).turnLeft()).isEqualTo(DIRECTION.NORTH);
        assertThat(getDirection(0).turnLeft()).isEqualTo(DIRECTION.WEST);

    }

    @Test
    void get_moved_xy() throws Exception {
         int[] currentPosition = new int[]{2, 3};
        DIRECTION direction = getDirection(0).turnLeft();
        int[] moveDirection = direction.getMoveDirection();
        int x = currentPosition[0] + moveDirection[0];
        int y = currentPosition[1] + moveDirection[1];
        assertThat(x).isEqualTo(2);
        assertThat(y).isEqualTo(2);
    }




    @Test
    void 움직임_테스트() throws Exception {
        int[][] map = new int[4][];
        map[0] = new int[]{1, 1, 1, 1};
        map[1] = new int[]{1, 0, 0, 1};
        map[2] = new int[]{1, 1, 0, 1};
        map[3] = new int[]{1, 1, 1, 1};

        DevelopGame developGame = new DevelopGame(map, new int[]{4-1, 4-1}, DIRECTION.NORTH);
        int count = developGame.moveTest();
        assertThat(count).isEqualTo(3);

    }




}

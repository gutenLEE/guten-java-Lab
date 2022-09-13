package algorithm.dfs;

import groovyjarjarpicocli.CommandLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author gutenlee
 * @since 2022/09/13
 */
public class EscapeMazeTest {
    int[][] maze;

    @BeforeEach
    void setUp() {
        maze = new int[5][6];
        maze[0] = new int[]{1,0,1,0,1,0};
        maze[1] = new int[]{1,1,1,1,1,1};
        maze[2] = new int[]{0,0,0,0,0,1};
        maze[3] = new int[]{1,1,1,1,1,1};
        maze[4] = new int[]{1,1,1,1,1,1};
    }

    @Test
    void test() throws Exception {
        int bfs = bfs(0, 0);
        assertThat(bfs).isEqualTo(10);
    }

    private int bfs(int x, int y) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        int n = maze.length;
        int m = maze[0].length;

        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = xy[0] + dx[i];
                int ny = xy[1] + dy[i];

                if (nx <0 || nx >= n || ny <0 || ny >= m)
                    continue;
                if (maze[nx][ny] == 0)
                    continue;
                if (maze[nx][ny] == 1) {
                    maze[nx][ny] = maze[xy[0]][xy[1]] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return maze[n-1][m-1];
    }

}

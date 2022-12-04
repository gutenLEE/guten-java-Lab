package algorithm.recursion;

/**
 * https://www.acmicpc.net/problem/2630
 * 색종이 만들기
 *
 * @author gutenlee
 * @since 2022/10/03
 */
public class OrigamiMaker {
    static int n = 8;
    static int[][] matrix = new int[8][8];
    static int whitePaperCount = 0;
    static int bluePaperCount = 0;

    public static void main(String[] args) {
        matrix[0]= new int[]{1, 1, 0, 0, 0, 0, 1, 1};
        matrix[1]= new int[]{1, 1, 0, 0, 0, 0, 1, 1};
        matrix[2]= new int[]{0, 0, 0, 0, 1, 1, 0, 0};
        matrix[3]= new int[]{0, 0, 0, 0, 1, 1, 0, 0};
        matrix[4]= new int[]{1, 0, 0, 0, 1, 1, 1, 1};
        matrix[5]= new int[]{0, 1, 0, 0, 1, 1, 1, 1};
        matrix[6]= new int[]{0, 0, 1, 1, 1, 1, 1, 1};
        matrix[7]= new int[]{0, 0, 1, 1, 1, 1, 1, 1};

        recurse(0, 0, n);
        System.out.println("whitePaperCount = " + whitePaperCount);
        System.out.println("bluePaperCount = " + bluePaperCount);
    }

    public static void recurse(int x, int y, int n) {
        int color = matrix[x][y];

        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (matrix[i][j]!=color) {
                    recurse(x, y, n/2);
                    recurse(x, y+n/2, n/2);
                    recurse(x+n/2, y, n/2);
                    recurse(x+n/2,y+n/2,n/2);
                    return;
                }
            }
        }
        if (color==0)
            whitePaperCount++;
        else
            bluePaperCount++;
    }
}

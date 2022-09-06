package algorithm.greedy;

import java.util.*;

/**
 * @author gutenlee
 * @since 2022/09/06
 */
public class MinMaker {
    private List<Integer> a;
    private List<Integer> b;

    public MinMaker(List<Integer> a, List<Integer> b) {
        Collections.sort(a);
        this.a = a;
        b.sort(Collections.reverseOrder());
        this.b = b;
    }

    public int getResultOfMinimumCombination() {
        int result = 0;
        for (int i = 0; i < a.size(); i++) {
            result += (a.get(i)*b.get(i));
        }
        return result;
    }


    public List<Integer> getA() {
        return a;
    }

    public List<Integer> getB() {
        return b;
    }

}

package javacollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gutenlee
 * @since 2022/09/21
 */
public class CollectionStudy_1 {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            arrayList.add(i);
        }
    }
}

package effectivejava.item17;

import java.util.HashMap;

/**
 * 객체를 만들 때 다른 불변 객체들을 구성요소로 사용하면 이점이 많다.
 *
 * @author gutenlee
 * @since 2023/01/04
 */
public class ImmutableClass_03 {

    public static void main(String[] args) {

        HashMap<ImmutableClass, String> map = new HashMap<>();

        ImmutableClass immutable_A = new ImmutableClass("A", "B", new MutableObject());

        map.put(immutable_A, "immutableA");

        immutable_A.setFieldA("change!!!! ");

        map.put(immutable_A, "immutableA again");

        System.out.println("map = " + map);
    }
}

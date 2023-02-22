package effectivejava.item24;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author gutenlee
 * @since 2023/02/21
 */
public class Item24Tester {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        Set<Map.Entry<String, String>> entrySet = map.entrySet();

        for (Map.Entry<String, String> entry : entrySet) {
            String value = entry.getValue();
            String key = entry.getKey();
        }
    }
}



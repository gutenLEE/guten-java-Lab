package effectivejava.item24;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author gutenlee
 * @since 2023/02/21
 */
public class MyCustomMap<K, V> extends AbstractMap<K, V> {

    private String mapName = "customMap";

    @Override
    public Set<Entry<K, V>> entrySet() {
        return new EntrySet();
    }

    final class EntrySet extends AbstractSet<Entry<K,V>> {

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }
    }
}

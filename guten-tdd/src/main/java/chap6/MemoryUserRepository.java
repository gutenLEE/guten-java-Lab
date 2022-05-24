package chap6;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gutenlee
 * @since 2022/05/25
 */
public class MemoryUserRepository implements UserRepository{

    private Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }
}

package chap5;

import java.time.LocalDateTime;

/**
 * @author gutenlee
 * @since 2022/05/23
 */
public class AutoDebitRepository {


    public AutoDebitInfo findOne(String userId) {
        return new AutoDebitInfo("idasd", "234234", LocalDateTime.now());
    }

    public void save(AutoDebitInfo newInfo) {
    }
}

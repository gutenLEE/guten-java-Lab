package refactorjsoup.factory;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.util.Map;

/**
 * @author gutenlee
 * @since 2022/11/17
 */
public class AConnection extends JsoupConnection {

    private int timeout;

    public AConnection(String url, Connection.Method method, Map<String, String> data, int timeout) {
        super(url, method);
    }

}

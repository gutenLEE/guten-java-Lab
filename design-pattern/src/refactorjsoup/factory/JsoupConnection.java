package refactorjsoup.factory;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

/**
 * @author gutenlee
 * @since 2022/11/17
 */
public abstract class JsoupConnection {

    private Connection connection;

    public JsoupConnection(String url, Connection.Method method) {
        reset(url, method);
    }

    public void reset(String url, Connection.Method method) {
        this.connection = Jsoup.connect(url).method(method);
    }

}

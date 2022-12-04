package refactorjsoup.factory;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.net.http.HttpHeaders;

/**
 * @author gutenlee
 * @since 2022/11/17
 */
public class BConnection extends JsoupConnection {
    private final int timeout;
    public BConnection(String url, Connection.Method method, int timeout) {
        super(url, method);
        this.timeout = timeout;
    }

}

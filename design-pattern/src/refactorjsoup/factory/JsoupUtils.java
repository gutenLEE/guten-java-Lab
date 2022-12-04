package refactorjsoup.factory;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

/**
 * @author gutenlee
 * @since 2022/11/17
 */
public class JsoupUtils {

    public static Connection getConnection(String url){
        return Jsoup.connect(url);
    }
    public static Connection getConnection(String url, Connection.Method method){
        return Jsoup.connect(url)
                .method(method);
    }
    public static Connection getConnection(String url, Connection.Method method, int timeout){
        return Jsoup.connect(url)
                .method(method)
                .timeout(timeout);
    }
    public static Connection getConnection(String url, Connection.Method method, int timeout, String userAgent){
        return Jsoup.connect(url)
                .method(method)
                .timeout(timeout)
                .userAgent(userAgent);
    }
}

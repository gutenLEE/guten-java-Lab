package refactorjsoup.factory;

import org.jsoup.Connection;
import refactorjsoup.effectivejavabuilder.RcJsoupConnection;

import java.util.HashMap;

/**
 * @author gutenlee
 * @since 2022/11/17
 */
public class JsoupApp {

    public static void main(String[] args) {
        JsoupUtils jsoupUtils = new JsoupUtils();

        Connection connection = null;
        connection = jsoupUtils.getConnection("https://www.naver.com");
        connection = jsoupUtils.getConnection("https://www.youtube.com", Connection.Method.GET);
        connection = jsoupUtils.getConnection("https://www.google.com", Connection.Method.GET, 20000, "Window");


        RcJsoupConnection mkConnection = new RcJsoupConnection
                .Builder("url", Connection.Method.GET)
                .timeout(1000)
                .build();



    }
}

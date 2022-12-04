package refactorjsoup.factory;

import org.jsoup.Connection;
import refactorjsoup.builder.MkConnection;

import java.util.HashMap;

/**
 * @author gutenlee
 * @since 2022/11/17
 */
public class JsoupFactory {

    public JsoupConnection createConnection(String serviceName){
        if (serviceName.equals("A"))
            return new AConnection("url", Connection.Method.GET, new HashMap<>(), 400); // 파라미터 주입....
        else if (serviceName.equals("B"))
            return new BConnection("url", Connection.Method.GET, 5000);
        return null;
    }
}

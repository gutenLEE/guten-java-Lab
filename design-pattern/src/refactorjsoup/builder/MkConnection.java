package refactorjsoup.builder;


import org.jsoup.Connection;
import org.jsoup.Jsoup;

/**
 * @author gutenlee
 * @since 2022/11/16
 */
public class MkConnection implements RcConnetion {

    private String url;
    private String method;
    private String timeout;
    private String userAgent;

    public Connection getConnection(){
        return Jsoup.connect(url);
    }
    public void hello(){
        System.out.println(" hello ");
    }
    public void setMethod(String method)
    {
        this.method = method;
    }

    public void setTimeout(String timeout)
    {
        this.timeout = timeout;
    }

    public void setUserAgent(String userAgent)
    {
        this.userAgent = userAgent;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "House{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", timeout='" + timeout + '\'' +
                ", userAgent='" + userAgent + '\'' +
                '}';
    }
}

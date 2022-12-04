package refactorjsoup.builder;

/**
 * @author gutenlee
 * @since 2022/11/16
 */
public interface RcConnetion {

    public void setUrl(String url);
    public void setMethod(String method);

    public void setTimeout(String timeout);

    public void setUserAgent(String userAgent);

}

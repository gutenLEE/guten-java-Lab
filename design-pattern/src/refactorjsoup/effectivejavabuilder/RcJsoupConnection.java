package refactorjsoup.effectivejavabuilder;

import org.jsoup.Connection;

import java.util.Map;

/**
 * @author gutenlee
 * @since 2022/11/17
 */
public class RcJsoupConnection {

    // required
    private String url;
    private Connection.Method method;
    // option
    private int timeout;
    private Map<String, String> data;

    public static class Builder {
        // required
        private String url;
        private Connection.Method method;

        // option
        private int timeout;
        private Map<String, String> data;

        public Builder(String url, Connection.Method method) {
            this.url = url;
            this.method = method;
        }

        public Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public Builder data(Map<String, String> data) {
            this.data = data;
            return this;
        }

        public RcJsoupConnection build() {
            return new RcJsoupConnection(this);
        }
    }

    private RcJsoupConnection(Builder builder){
        this.url = builder.url;
        this.method = builder.method;
        this.timeout = builder.timeout;
        this.data = builder.data;
    }
}

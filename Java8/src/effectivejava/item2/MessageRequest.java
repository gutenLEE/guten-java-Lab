package effectivejava.item2;


/**
 * @author gutenlee
 * @since 2022/12/09
 */

// base class
public abstract class MessageRequest {

    private String from;
    private String to;
    private String clientRef;

    public abstract static class Builder<B extends Builder<? extends B>> {
        protected String from, to, clientRef;

        public B from(String from) {
            this.from = from;
            return (B) this;
        }

        public B to(String to) {
            this.to = to;
            return (B) this;
        }

        public B clientRef(String clientRef) {
            this.clientRef = clientRef;
            return (B) this;
        }

        public abstract MessageRequest build();
    }
}
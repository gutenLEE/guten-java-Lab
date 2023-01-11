package effectivejava.item18;

/**
 * @author gutenlee
 * @since 2023/01/11
 */
public class BaseDecorator {

    private final Notifier notifier;


    public BaseDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String message) {
        notifier.send(message);
    }
}

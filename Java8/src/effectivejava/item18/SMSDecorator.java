package effectivejava.item18;

/**
 * @author gutenlee
 * @since 2023/01/11
 */
public class SMSDecorator extends BaseDecorator {

    public SMSDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
    }
}

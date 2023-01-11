package effectivejava.item18;

/**
 * @author gutenlee
 * @since 2023/01/11
 */
public class SMS implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("SMS send...." + message);
    }
}

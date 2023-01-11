package effectivejava.item18;

import java.util.HashSet;

/**
 * @author gutenlee
 * @since 2023/01/11
 */
public class Tester {
    public static void main(String[] args) {

        SMSDecorator smsDecorator = new SMSDecorator(new SMS());
        smsDecorator.send("문자 내용 : 솰라솰라");

        BaseDecorator baseDecorator = new BaseDecorator(new Facebook());
        baseDecorator.send("Facebook message : 솰라솰라");
    }
}

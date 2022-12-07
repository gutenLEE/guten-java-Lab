package effectivejava.item1;

import static effectivejava.item1.Os.getOs;

/**
 * @author gutenlee
 * @since 2022/12/06
 */
public class Client {
    public static void main(String[] args) {
        Os os = getOs("amd");
        System.out.println("os " + System.identityHashCode(os));
        os.boot();

        Os os2 = getOs("intel");
        System.out.println("os2 " + System.identityHashCode(os2));
        os2.boot();
    }
}

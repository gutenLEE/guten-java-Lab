package effectivejava.item1;

/**
 * @author gutenlee
 * @since 2022/12/06
 */
public class Intel implements Os {
    @Override
    public void boot() {
        System.out.println("Intel " + System.identityHashCode(this));
        System.out.println("intel booting....");
    }

    @Override
    public void format() {

    }
}

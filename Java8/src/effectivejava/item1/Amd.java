package effectivejava.item1;

/**
 * @author gutenlee
 * @since 2022/12/06
 */
public class Amd implements Os {
    @Override
    public void boot() {
        System.out.println("Amd " + System.identityHashCode(this));
        System.out.println("Amd booting....");
    }

    @Override
    public void format() {

    }
}

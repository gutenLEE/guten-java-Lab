package effectivejava.item1;

/**
 * @author gutenlee
 * @since 2022/12/06
 */
public interface Os {
    void boot();
    void format();

    static Os getOs(String type) {
        if ("amd".equalsIgnoreCase(type))
            return new Amd();
        else
            return new Intel();
    }
}

package strategypattern.sample;

/**
 * @author gutenlee
 * @since 2022/07/19
 */
public class Goblin extends Target{

    public Goblin() {
        setSize(Size.NORMAL);
        setVisibility(Visibility.VISIBLE);
    }

    @Override
    public String toString() {
        return "Goblin";
    }

}

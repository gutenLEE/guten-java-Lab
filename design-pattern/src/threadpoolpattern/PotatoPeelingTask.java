package threadpoolpattern;

/**
 * @author gutenlee
 * @since 2022/07/12
 */
public class PotatoPeelingTask extends Task {

    private static final int TIME_PER_POTATO = 200;

    public PotatoPeelingTask(int numPotatoes) {
        super(numPotatoes * TIME_PER_POTATO);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

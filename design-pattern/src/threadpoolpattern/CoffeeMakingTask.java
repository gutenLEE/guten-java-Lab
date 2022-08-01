package threadpoolpattern;

/**
 * @author gutenlee
 * @since 2022/07/12
 */
public class CoffeeMakingTask extends Task{

    private static final int TIME_PER_CUP = 100;

    public CoffeeMakingTask(int numCups) {
        super(numCups * numCups);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

package strategypattern.sample;

/**
 * @author gutenlee
 * @since 2022/07/19
 */
public class App {

    public static void main(String[] args) {
        var wizard = new Wizard();
        var goblin = new Goblin();

        goblin.printStatus();

        wizard.castSpell(goblin::changeSize);
        goblin.printStatus();
    }
}

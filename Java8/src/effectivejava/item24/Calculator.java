package effectivejava.item24;

/**
 * @author gutenlee
 * @since 2023/02/21
 */
public class Calculator {

    private final Integer valueA;

    public Calculator(Integer valueA) {
        this.valueA = valueA;
    }

    public Integer doSomething(){
        return valueA;
    }

    public enum UnitOperation implements Calculable {
        ONE {
            public int calculate(int value) {
                return value;
            }
        },
        THOUSAND {
            public int calculate(int value) {
                return value*1_000;
            }
        };
    }
}

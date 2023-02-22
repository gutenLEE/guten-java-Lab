package effectivejava.item24;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CalculatorTest {

    @Test
    @DisplayName("정적 멤버클래스")
    void staticMemberClassTest() throws Exception {

        Calculator calculator = new Calculator(500);
        Integer value = calculator.doSomething();

        int valueWon = Calculator.UnitOperation.ONE.calculate(value);
        int valueThousandWon = Calculator.UnitOperation.THOUSAND.calculate(value);

        Assertions.assertEquals(500, valueWon);
        Assertions.assertEquals(500_000, valueThousandWon);
    }


    @Test
    void nonStaticMemberClass() throws Exception {

        MyCustomMap<String, String> customMap = new MyCustomMap<>();
        customMap.new EntrySet();
    }



}
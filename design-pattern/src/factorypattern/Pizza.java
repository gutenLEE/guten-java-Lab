package factorypattern;

import java.awt.datatransfer.MimeTypeParseException;
import java.lang.reflect.GenericArrayType;

public abstract class Pizza {

    void prepare() {

    }

    void bake() {

    }

    void cut() {

    }

    void box() {

    }


    public Pizza orderPizza(String type) {
        Pizza pizza;

        // 피자 종류가 바뀔 때마다 바뀌는 부분. -> 변경에 닫혀있지 않음. -> 캡슐화 해야함.
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("greek")) {
            pizza = new GreekPizza();
        } else {
            pizza = new PepperoniPizza();
        }

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        return pizza;
    }
}

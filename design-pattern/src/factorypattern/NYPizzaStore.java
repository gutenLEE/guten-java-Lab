package factorypattern;

import factorypattern.ingredient.NYIngredient;
import factorypattern.ingredient.PizzaIngredientFactory;

public class NYPizzaStore extends PizzaStore {


    public NYPizzaStore(SimplePizzaFactory simplePizzaFactory) {
        super(simplePizzaFactory);
    }


    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYIngredient();
        // 주문 시스템은 상위 클래스를 따르지만, 피자 스타일은 이제 각자 결정할 수 있다.
        if (type.equals("cheese")) {
            pizza = new NYStyleCheesePizza(ingredientFactory);
        }
        return pizza;
    }
}

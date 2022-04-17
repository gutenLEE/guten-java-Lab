package factorypattern;

import factorypattern.ingredient.NYIngredient;
import factorypattern.ingredient.PizzaIngredientFactory;

public class CaliforniaPizzaStore extends PizzaStore{

    public CaliforniaPizzaStore(SimplePizzaFactory simplePizzaFactory) {
        super(simplePizzaFactory);
    }

    @Override
    Pizza createPizza(String type) {
        PizzaIngredientFactory ingredientFactory = new NYIngredient();
        Pizza pizza =  null;
        // 주문 시스템은 상위 클래스를 따르지만, 피자 스타일은 이제 각자 결정할 수 있다.
        if (type.equals("cheese")) {
            pizza = new NYStyleCheesePizza(ingredientFactory);
        }
        return pizza;
    }
}

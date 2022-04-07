package factorypattern;

public class PizzaStore {

    SimplePizzaFactory  simplePizzaFactory;

    public PizzaStore(SimplePizzaFactory simplePizzaFactory) {
        this.simplePizzaFactory = simplePizzaFactory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = null;
        pizza = simplePizzaFactory.createPizza("cheese");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        return pizza;
    }
}

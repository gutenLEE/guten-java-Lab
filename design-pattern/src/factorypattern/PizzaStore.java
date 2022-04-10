package factorypattern;

public abstract class PizzaStore {

    SimplePizzaFactory  simplePizzaFactory;

    public PizzaStore(SimplePizzaFactory simplePizzaFactory) {
        this.simplePizzaFactory = simplePizzaFactory;
    }


    // 모든 지점에서 이 주문 시스템을 따라 주문이 진행된다.
    public Pizza orderPizza(String type) {
        Pizza pizza = null;
        // pizza 는 추상클래스여서 실제로 어떤 구상 클래스에서 작업이 처리되고 있는지 전혀 알 수 없다.
        // -> pizza와 pizzaStore는 완전히 분리되어 있다.
        pizza = createPizza("cheese");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        return pizza;
    }

    // 누가 피자의 스타일을 결정하나 ? -> 구상 클래스가 피자의 스타일을 결정한다.
    // 팩토리 메소드
    abstract Pizza createPizza(String type);
}

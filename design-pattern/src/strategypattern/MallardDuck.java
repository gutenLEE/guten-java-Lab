package strategypattern;

public class MallardDuck extends Duck {

    public MallardDuck() {
        this.flyBehavior = new FlyWithWings();
    }

    @Override
    void quack() {

    }

    @Override
    void swim() {

    }

    @Override
    void display() {

    }
}

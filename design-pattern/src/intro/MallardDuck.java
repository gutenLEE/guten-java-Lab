package intro;

public class MallardDuck extends Duck {

    public MallardDuck() {
        this.flyBehavior = new FlyWithWings();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
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

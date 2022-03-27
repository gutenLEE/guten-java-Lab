package intro;

public abstract class Duck {
    FlyBehavior flyBehavior;

    abstract void quack();
    abstract void swim();
    abstract void display();
    public void performFly() {
        flyBehavior.fly();
    }
}
// test
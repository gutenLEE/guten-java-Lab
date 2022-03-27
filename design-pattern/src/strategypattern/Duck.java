package strategypattern;

public abstract class Duck {
    FlyBehavior flyBehavior;

    abstract void quack();
    abstract void swim();
    abstract void display();
    public void performFly() {
        flyBehavior.fly();
    }

    /**
     * setter 메서드를 구현체에 위치하면 문제점?
     * @param fb
     */
    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }
}

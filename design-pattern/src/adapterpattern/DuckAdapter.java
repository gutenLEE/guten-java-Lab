package adapterpattern;

public class DuckAdapter implements Turkey{

    Duck duck;

    public DuckAdapter(Duck duck) {
        this.duck = duck;
    }

    @Override
    public void gobble() {
        this.duck.quack();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 2; i++) {
            this.duck.fly();
        }
    }
}

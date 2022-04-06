package decoratepattern;

public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + .33;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", " + "whip";
    }
}

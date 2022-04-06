package decoratepattern;

public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        double cost = Double.NaN;
        if (this.beverage.getSize() == Size.GRANDE) {
            cost = .9;
        } else if (this.beverage.getSize() == Size.TALL) {
            cost = .11;
        } else {
            cost = 3.0;
        }
        return beverage.cost() + cost;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", " + "whip";
    }
}

package decoratepattern;

public class Espresso extends Beverage {

    private double cost = 1.99;

    public Espresso () {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}

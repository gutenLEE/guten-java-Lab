package decoratepattern;

public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage1 = new Mocha(beverage);
        Beverage beverage2 = new Whip(beverage1);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

    }
}

package decoratepattern;

public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        beverage.setSize(Beverage.Size.GRANDE);
        Beverage beverage1 = new Whip(beverage);
        // beverage1 에서도 사이즈 변경하면 문제 발생하지 않나?
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());


    }
}

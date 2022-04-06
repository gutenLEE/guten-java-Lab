package decoratepattern;

public abstract class Beverage {

    public enum Size { TALL, GRANDE, VENTI };
    Size size = Size.TALL;

    String description = "no title";

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return this.size;
    }

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

package decoratepattern;

/**
 * 데코레이터 클래스
 */
public abstract class CondimentDecorator extends Beverage {
    Beverage beverage;
    public abstract String getDescription();
}

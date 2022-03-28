package observerpattern;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temp;
    private float humidity;
    private float pressure;

    @Override
    public void display() {

    }


    @Override
    public void update(float temp, float humidity, float pressure) {

    }
}

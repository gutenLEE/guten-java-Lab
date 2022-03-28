package observerpattern;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temp;
    private float humidity;
    private float pressure;

    @Override
    public void display() {
        System.out.println("temp = " + temp);
        System.out.println("humidity = " + humidity);
        System.out.println("pressure = " + pressure);
    }


    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        // 아....주제에서 옵저버의 업데이트 메서드를 호출하는 구나
        this.display();
    }
}

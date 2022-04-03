package observerpattern;

public class MaxMinConditionsDisplay implements Observer, DisplayElement {

    private float max = Float.MIN_VALUE;
    private float min = Float.MAX_VALUE;
    private float avg = Float.NaN;

    private float temp;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;

    public MaxMinConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.printf("현재 온도 %.2f 현재 습도 %.2f \n", this.temp, this.humidity);
        System.out.printf("평균 %.2f // 최고 %.2f// 최저 %.2f ", avg, max, min);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.display();
    }

    @Override
    public void update() {
        this.humidity = weatherData.getHumidity();
        this.temp = weatherData.getTemperature();
        this.pressure = weatherData.getPressure();

        if (max <= temp) {
            max = temp;
        }
        if (min >= temp) {
            min = temp;
        }
        avg = (min + max) / 2;
        display();
    }
}

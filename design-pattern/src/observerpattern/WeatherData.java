package observerpattern;

public class WeatherData {
    public void measurementsChanged() {
        // 최신 데이터 수집
        float temp = getTemperature();
        float humidity = getHumidity();
        float pressure = getPressure();
    }

    // 각 디스플레이 갱신.

    private float getPressure() {
        return 0;
    }

    private float getHumidity() {
        return 0;
    }

    private float getTemperature() {
        return 0;
    }
}

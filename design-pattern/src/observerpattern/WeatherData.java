package observerpattern;

import java.util.List;

/**
 * Observer Pattern :
 *  한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체에게 연락이 가고 자동으로 내용이 갱신되는 방식으로 일대다의
 *  의존성을 정의합니다.
 */
public class WeatherData implements Subject {

    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void registerObserver(Observer ob) {

    }

    @Override
    public void removeObserver(Observer ob) {

    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        // 최신 데이터 수집
        float temp = getTemperature();
        float humidity = getHumidity();
        float pressure = getPressure();

        // 각 디스플레이 갱신.
    }


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

package observerpattern;

import java.util.ArrayList;
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

    public WeatherData( ) {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer ob) {
        observers.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) {
        observers.remove(ob);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }

    // 주제의 상태가 변경되었을 때만 이 메서드가 호출되면,
    // 옵저버들 객체의 필드 상태값이 변경되었다는것인데,
    // 옵저버들은 자기들의 상태가 바뀐걸 어찌 알지?
    // 스스로 체크하나?
    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}

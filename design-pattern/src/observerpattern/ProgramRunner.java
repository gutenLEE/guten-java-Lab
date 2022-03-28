package observerpattern;

public class ProgramRunner {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
        weatherData.registerObserver(currentConditionsDisplay);
        weatherData.setMeasurements(0.2f, 0.4f, 0.4f);

    }
}

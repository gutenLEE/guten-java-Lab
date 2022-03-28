package observerpattern;

public class ProgramRunner {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
        weatherData.registerObserver(currentConditionsDisplay);

    }
}

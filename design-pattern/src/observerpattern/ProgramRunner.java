package observerpattern;

public class ProgramRunner {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(0.2f, 0.4f, 0.4f);

        MaxMinConditionsDisplay maxMinConditionsDisplay = new MaxMinConditionsDisplay(weatherData);
        weatherData.setMeasurements(80, 65, Float.NaN);
        weatherData.setMeasurements(82, 70, Float.NaN);
    }
}

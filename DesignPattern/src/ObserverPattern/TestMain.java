package ObserverPattern;

public class TestMain {
	public static void main(String[] args) {
		Subject weatherData = new WeatherData();
		Observer forcasteDisplay = new ForcasteDisplay();
		Observer generalDisplay = new GeneralDisplay();
		weatherData.addObserver(generalDisplay);
		weatherData.addObserver(forcasteDisplay);
		Data data1 = new Data(1.0f, 2.0f, 4.0f);
		Data data2 = new Data(2.0f, 3.0f, 4.0f);
		weatherData.setMeasurements(data1);
		weatherData.setMeasurements(data2);
	}
	
}

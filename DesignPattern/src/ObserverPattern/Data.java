package ObserverPattern;

public class Data {
	private float humidity;
	private float temperature;
	private float heat;
	public Data(float humidity, float temperature, float heat) {
		this.humidity = humidity;
		this.temperature = temperature;
		this.heat = heat;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	@Override
	public String toString() {
		return "Data [humidity=" + humidity + ", temperature=" + temperature + ", heat=" + heat + "]";
	}
	
	
	
}

package ObserverPattern;

public interface Subject {
	public void addObserver(Observer observer);
	public void removeObserver(Observer observer);
	public void notifyObserver();
	public void setMeasurements(Data data);
}

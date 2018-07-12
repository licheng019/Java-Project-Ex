package ObserverPattern;

import java.util.ArrayList;

public class WeatherData implements Subject {
	private ArrayList<Observer> observerList;
	private Data data;
	private boolean changed;
	
	public WeatherData() {
		observerList = new ArrayList<>();
		changed = false;
	}
	@Override
	public void addObserver(Observer observer) {
		observerList.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		int index = 0;
		for (Observer obser: observerList) {
			if (obser.equals(observer)) {
				break;
			}
			index++;
		}
		observerList.remove(index);
	}

	@Override
	public void notifyObserver() {
		if (changed) {
			for (Observer observer: observerList) {
				observer.update(data);
			}
			changed = false;
		}
	}
	
	public void setChanged() {
		this.changed = true;
	}

	@Override
	public void setMeasurements(Data data) {
		this.data = data;
		setChanged();
		notifyObserver();
	}
	
}

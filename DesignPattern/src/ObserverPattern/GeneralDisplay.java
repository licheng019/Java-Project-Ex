package ObserverPattern;

public class GeneralDisplay implements Observer {
	private Data data;
	
	@Override
	public void update(Data data) {
		this.data = data;
		display();
	}
	
	public void display() {
		System.out.println(this.toString());
	}
	@Override
	public String toString() {
		return "GeneralDisplay" + data.toString();
	}
	
	
}

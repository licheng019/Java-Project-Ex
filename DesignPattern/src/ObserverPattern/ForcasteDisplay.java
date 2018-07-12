package ObserverPattern;

public class ForcasteDisplay implements Observer {
	private Data data;
	@Override
	public void update(Data data) {
		this.data = data;
		display();
	}

	@Override
	public void display() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "ForcasteDisplay" + data.toString();
	}
	
	
}

package ProxyPattern;

public class Seller implements Subject {
	private String houseName;
	
	public Seller(String houseName) {
		this.houseName = houseName;
	}
	
	@Override
	public void sellHouse() {
		System.out.println("I only want to sell the house " + houseName);
	}

}

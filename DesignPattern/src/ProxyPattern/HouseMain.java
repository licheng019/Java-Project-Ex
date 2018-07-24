package ProxyPattern;

public class HouseMain {
	public static void main(String[] args) {
		ProxySeller seller1 = new ProxySeller(new Seller("house A"));
		seller1.sellHouse();
		System.out.println("~~~~~~~~");
		ProxySeller seller2 = new ProxySeller(new Seller("house B"));
		seller2.sellHouse();
	}
}

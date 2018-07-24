package ProxyPattern;

public class ProxySeller implements Subject {
	
	Seller seller;
	
	public ProxySeller(Seller seller) {
		this.seller = seller;
	}
	public void preSelling() {
		System.out.println("Please sign docuemnt before I do my work");
	}
	@Override
	public void sellHouse() {
		preSelling();
		seller.sellHouse();
		postSelling();
	}
	
	public void postSelling() {
		System.out.println("House has already been sold, Please pay me. the business is done.");
	}

}

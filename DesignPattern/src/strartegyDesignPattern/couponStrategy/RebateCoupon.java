package strartegyDesignPattern.couponStrategy;

public class RebateCoupon implements Coupon {
	public int initialPrice;
	public int rebatePrice;

	public RebateCoupon(int initialPrice, int rebatePrice) {
		this.initialPrice = initialPrice;
		this.rebatePrice = rebatePrice;
	}
	
	public double rebate(double originalPrice){
		int times = (int)originalPrice / initialPrice;
		int rebateAmouant = times * rebatePrice;
		return originalPrice - rebateAmouant;
	}
}

package strartegyDesignPattern.couponStrategy;

public class NintyPercent implements DiscountCoupon{

	@Override
	public double discount() {
		return 0.9;
	}

}

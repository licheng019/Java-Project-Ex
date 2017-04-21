package strartegyDesignPattern;

import strartegyDesignPattern.couponStrategy.NintyPercent;
import strartegyDesignPattern.couponStrategy.RebateCoupon;
import strartegyDesignPattern.model.Order;
import strartegyDesignPattern.model.Product;

public class MainTest {
	public static void main(String[] args) {
		Product shoes = new Product("Nike Shoes",59.99);
		Product book = new Product("Spring boot in action",59.99);
		Order order = new Order();
		order.addProduct(book);
		order.addProduct(shoes);
		order.addDiscountStrategy(new NintyPercent());
		order.addDiscountStrategy(new RebateCoupon(100,10));
		System.out.println(order.finalAmount());
	}
}

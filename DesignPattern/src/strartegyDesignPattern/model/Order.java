package strartegyDesignPattern.model;

import java.util.ArrayList;
import java.util.List;

import strartegyDesignPattern.couponStrategy.Coupon;
import strartegyDesignPattern.couponStrategy.DiscountCoupon;
import strartegyDesignPattern.couponStrategy.RebateCoupon;

public class Order {
	List<Product> productList;
	List<Coupon> couponList;
	public Order() {
		productList = new ArrayList<Product>();
		couponList = new ArrayList<Coupon>();
	}
	
	public void addProduct(Product product) {
		productList.add(product);
	}
	
	public void removeProduct(Product product) {
		productList.remove(product);
	}
	
	public double originalAmount() {
		double totalPrice = 0;
		for (Product product: productList) {
			totalPrice += product.getPrice();
		}
		return totalPrice;
	}
	
	public List<Coupon> addDiscountStrategy(Coupon coupon){
		couponList.add(coupon);
		return couponList;
	}
	
	public double finalAmount() {
		//use two kinds of coupon
		double totalPrice = 0;
		for (Product product : productList) {
			totalPrice += product.getPrice();
		}
		if (couponList.size() == 2) {
			DiscountCoupon discount = null;
			RebateCoupon rebate = null;
			for (Coupon coupon: couponList) {
				
				if (coupon.getClass().equals(RebateCoupon.class)) {
					rebate = (RebateCoupon)coupon;
				} else {
					discount = (DiscountCoupon)coupon;
				}
			}
			double finalPrice = totalPrice * discount.discount();
			double rebatePrice = rebate.rebate(finalPrice);
			return rebatePrice;
		} else if (couponList.size() == 1){
			if (couponList.get(0).getClass().equals(RebateCoupon.class)) {
				RebateCoupon rebate = (RebateCoupon)couponList.get(0);
				return rebate.rebate(totalPrice);
			} else {
				DiscountCoupon discount = (DiscountCoupon)couponList.get(0);
				return discount.discount() * totalPrice;
			}
		} else {
			return totalPrice;
		}
	}
}

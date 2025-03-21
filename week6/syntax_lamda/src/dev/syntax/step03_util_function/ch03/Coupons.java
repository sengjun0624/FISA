package dev.syntax.step03_util_function.ch03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Coupons {
	private static List<String> coupons = List.of("10$", "100$", "200$", "500$", "1000$", "2000$");

	public static List<String> getAvailableCoupons(int numberOfCoupons, Supplier<String> couponPattern) {

		List<String> availableCoupons = new ArrayList<>();
		for (int i = 0; i < numberOfCoupons; i++) {
			availableCoupons.add(couponPattern.get());
		}
		return availableCoupons;
	}

	public static Supplier<String> getCoupon() {

		return () -> coupons.get(new Random().nextInt(coupons.size()));
	}

	public static Supplier<String> getCouponLessThen500() {
		return () -> coupons.get(new Random().nextInt(coupons.size() - 2));

	}

	public static Supplier<String> getCouponExpensive() {

		return () -> coupons.get(coupons.size() - 1);
	}
}

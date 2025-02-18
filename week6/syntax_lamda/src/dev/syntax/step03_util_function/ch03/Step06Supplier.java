package dev.syntax.step03_util_function.ch03;

import static dev.syntax.step03_util_function.ch03.Coupons.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/*
/**
 * Represents a supplier of results.
 *
 * @param <T> the type of results supplied by this supplier

@FunctionalInterface
public interface Supplier<T> {

    // gets a result
    T get();
}
 */
public class Step06Supplier {
	public static void main(String[] args) {
		// 1. 랜덤으로 2개의 쿠폰을 추출


		System.out.println(Coupons.getAvailableCoupons(2, getCoupon()));

		// 2. 랜덤으로 6장의 쿠폰을 추출하되, 최대 500달러에 속하는 쿠폰으로 추출
		System.out.println(Coupons.getAvailableCoupons(6, getCouponLessThen500()));

		// 3. 가장 비싼 쿠폰 추출
		System.out.println(Coupons.getAvailableCoupons(1, getCouponExpensive()));
	}


}

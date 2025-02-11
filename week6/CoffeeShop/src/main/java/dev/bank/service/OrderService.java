package dev.bank.service;

import static dev.bank.formatter.NumberFormatter.*;

import java.util.List;

import dev.bank.model.Order;
import dev.bank.model.enums.Drink;
import dev.bank.model.enums.OrderType;

public class OrderService {
	public void pay(Order order) {
		int totalAmount = calculateTotal(order.getDrinkList(), order.getOrderType());
		System.out.println("총 주문 금액: " + formatNumber(totalAmount) + "원");
		System.out.println(formatNumber(order.getReceivedAmount()) + "원 지불하셨습니다.");

		if (order.getReceivedAmount() < totalAmount)
			System.out.println("지불한 금액이 부족합니다.\n 결제에 실패했습니다.");
		else
			System.out.println("거스름돈은 " + formatNumber(order.getReceivedAmount() - totalAmount) + "원 입니다.");
	}

	public int calculateTotal(List<Drink> drinkList, OrderType orderType) {
		int ret = 0;
		for (Drink drink : drinkList) {
			ret = ret + drink.getPrice();
			if (orderType == OrderType.테이크아웃)
				ret -= 500;
		}
		return ret;
	}
}

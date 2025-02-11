package dev.bank.service;

import static dev.bank.formatter.NumberFormatter.*;

import java.util.List;

import dev.bank.model.Order;
import dev.bank.model.enums.Drink;
import dev.bank.model.enums.OrderType;

public class OrderService {
	public void pay(Order order) {
		int totalAmount = calculateTotal(order.getDrinkList(), order.getOrderType());
		long receivedAmount = order.getReceivedAmount();
		long change = receivedAmount - totalAmount;

		System.out.println("\n+------------------------+");
		System.out.println("|      📜 영수증        |");



		System.out.println("+------------------------+");
		System.out.printf("| 🛒 총 주문 금액  %7s원 |\n", formatNumber(totalAmount));
		System.out.printf("| 💳 지불 금액    %7s원 |\n", formatNumber(receivedAmount));
		System.out.println("+------------------------+");

		if (receivedAmount < totalAmount) {
			System.out.println("| ❌ 지불한 금액이 부족합니다. |");
			System.out.println("| ⛔ 결제 실패! 추가 지불 필요 |");
		} else {
			System.out.printf("| 💰 거스름돈     %7s원 |\n", formatNumber(change));
			System.out.println("| ✅ 결제가 완료되었습니다. |");
		}

		System.out.println("+------------------------+");
		System.out.println("|  ☕ 감사합니다! 좋은 하루  |");
		System.out.println("+------------------------+\n");
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

package dev.bank.printer;

import dev.bank.model.Order;
import dev.bank.model.enums.Drink;
import dev.bank.model.enums.OrderType;

public class OrderTypePrinter {
		public static void printOrderType(OrderType orderType) {
			System.out.println(String.format("%s를 선택하셨습니다.",orderType));
	}
}

package dev.bank.parser;

import dev.bank.model.Order;
import dev.bank.model.enums.OrderType;

public class OrderTypeParser {
	public static OrderType parseOrderType(int type) {
		if (type == 1) {
			return OrderType.매장;
		} else
			return OrderType.테이크아웃;
	}
}

package dev.bank.parser;

import dev.bank.model.Order;
import dev.bank.model.enums.OrderType;

// 함수형 인터페이스. Lamda
public class OrderTypeParser {
	public static OrderType parseOrderType(int type) {
		if (type == 1) {
			return OrderType.매장;
		} else if(type == 2){
			return OrderType.테이크아웃;
		}
		//default
		else return null;
	}
}

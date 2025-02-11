package dev.bank.model;

import static dev.bank.formatter.NumberFormatter.*;
import static dev.bank.parser.DrinkParser.*;
import static dev.bank.parser.OrderTypeParser.*;
import static dev.bank.printer.DrinkPrinter.*;
import static dev.bank.printer.OrderTypePrinter.*;
import static dev.bank.util.Input.*;
import static dev.bank.validator.InputValidator.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import dev.bank.model.enums.Drink;
import dev.bank.model.enums.OrderType;
import dev.bank.service.OrderService;

public class CoffeeOrder {
	private static List<Drink> drinkList = new ArrayList<>();
	private static final OrderService orderService = new OrderService();

	public static void orderProcess() throws IOException, InterruptedException {
		System.out.println("안녕하세요 주문을 시작하겠습니다.");
		System.out.println();

		System.out.println("주문 유형을 입력하세요. (1/2)");
		System.out.println("1. 매장 \n2. 테이크 아웃 (500원 할인)");

		int orderNumber = NumberReader();
		OrderType orderType = parseOrderType(orderNumber);
		printOrderType(orderType);

		while (true) {
			System.out.println("음료를 선택하세요.");
			System.out.println("1. 아메리카노 - 2000원 \n2. 라떼 - 2500원");
			int drinkNumber = NumberReader();
			Drink drinkType = parseDrink(drinkNumber);
			printDrink(drinkType);
			drinkList.add(drinkType);

			System.out.println("현재 금액: "+ formatNumber(orderService.calculateTotal(drinkList, orderType)));
			if(AnswerReader().equals("No"))break;
		}
		long receivedMoney = payReader();
		Order order = new Order(drinkList, orderType,receivedMoney);
		System.out.println();

		orderService.pay(order);

		System.out.println();

		Thread.sleep(3000);
		System.out.println("주문하신 음료가 나왔습니다. ");
		Thread.sleep(1000);

	}
}


package dev.bank.model;

import static dev.bank.formatter.NumberFormatter.*;
import static dev.bank.parser.DrinkParser.*;
import static dev.bank.parser.OrderTypeParser.*;
import static dev.bank.printer.DrinkPrinter.*;
import static dev.bank.printer.OrderTypePrinter.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import dev.bank.model.enums.Drink;
import dev.bank.model.enums.OrderType;
import dev.bank.service.OrderService;

public class CoffeeOrder {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static List<Drink> drinkList = new ArrayList<>();
	private static final OrderService orderService = new OrderService();

	public static void orderProcess() throws IOException, InterruptedException {
		System.out.println("안녕하세요 주문을 시작하겠습니다.");
		System.out.println();
		System.out.println("주문 유형을 입력하세요. (1/2)");
		System.out.println("1. 매장 \n2. 테이크 아웃 (500원 할인)");

		String input = br.readLine();
		OrderType orderType = parseOrderType(Integer.parseInt(input));
		printOrderType(orderType);

		while (true) {
			System.out.println("음료를 선택하세요. (1/2)");
			System.out.println("1. 아메리카노 - 2000원 \n2. 라떼 - 2500원");
			input = br.readLine();

			Drink drinkType = parseDrink(Integer.parseInt(input));
			printDrink(drinkType);
			drinkList.add(drinkType);

			System.out.println("현재 금액: "+ formatNumber(orderService.calculateTotal(drinkList, orderType)));
			System.out.println("추가 주문을 하시겠습니까? (Yes/No)");
			input = br.readLine();
			if (!input.equals("Yes") && !input.equals("Y")&&!input.equals("yes")&&!input.equals("y")&&!input.equals("1")) {
				break;
			}
		}
		System.out.print("지불 금액 입력: ");
		Order order = new Order(drinkList, orderType, Integer.parseInt(br.readLine()));
		System.out.println();

		orderService.pay(order);
		System.out.println();
		System.out.println("프로그램이 3초 뒤 종료됩니다.");
		Thread.sleep(3000);
	}
}


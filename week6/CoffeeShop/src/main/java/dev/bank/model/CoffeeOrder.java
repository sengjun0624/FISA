package dev.bank.model;

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

	public static void orderProcess() throws IOException {
		System.out.println("안녕하세요 주문을 시작하겠습니다.");
		System.out.println("주문 유형을 선택하세요");
		System.out.println("매장(1) - 테이크 아웃(2)");

		String input = br.readLine();
		OrderType orderType = parseOrderType(Integer.parseInt(input));
		printOrderType(orderType);

		while (true) {
			System.out.println("음료를 선택하세요.");
			System.out.println("아메리카노(1) - 라떼(2)");
			input = br.readLine();

			Drink drinkType = parseDrink(Integer.parseInt(input));
			printDrink(drinkType);
			drinkList.add(drinkType);

			System.out.println("추가 주문을 하시겠습니까? (Yes/No)");
			input = br.readLine();
			if (!input.equals("Yes") && !input.equals("Y")&&!input.equals("yes")&&!input.equals("y")&&!input.equals("1")) {
				break;
			}
		}
		System.out.println("지불 금액 입력");
		Order order = new Order(drinkList, orderType, Integer.parseInt(br.readLine()));
		orderService.pay(order);
	}
}


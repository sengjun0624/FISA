package dev.bank.util;

import static dev.bank.validator.InputValidator.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int NumberReader() {
		int input = 0;
		while (true) {
			try {

				input = Integer.parseInt(br.readLine());
				if (validateNumber(input))
					break;
				else
					System.out.println("1 또는 2를 선택해주세요!");
			} catch (NumberFormatException | IOException e) {
				System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
			}
		}
		return input;
	}

	public static String AnswerReader() {
		String input = "";
		System.out.println("추가 주문을 하시겠습니까? (Yes/No)");
		while (true) {
			try {
				input = br.readLine();
				if (validateAnswer(input))
					break;
				else
					System.out.println("Yes 또는 No를 선택해주세요!");
			} catch (NumberFormatException | IOException e) {
				System.out.println("잘못된 입력입니다.");
			}
		}

		return input;
	}

	public static long payReader() {
		Long ret = 0L;
		while (true) {
			try {
				System.out.print("지불 금액 입력: ");
				String input = br.readLine();
				ret = Long.parseLong(input);
				if (ret < 0)
					throw new NumberFormatException();
				break;
			} catch (NumberFormatException | IOException e) {
				System.out.println("잘못된 입력입니다.");
			}
		}
		return ret;
	}
}

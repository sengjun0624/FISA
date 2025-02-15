package dev.service.cloud;

import static util.AsciiArt.*;

public class Main {
	public static void main(String[] args) {
		// 람다 표현식 사용
		AddFunction addition = (a, b) -> a + b;

		// 결과 출력
		System.out.println("10 + 5 = " + addition.add(10, 5));
	}
}

package dev.syntax.step01_lamda;

public class Main {
	public static void main(String[] args) {
		// 생성, 사용 방법 첫 번째 - 단순 객체 생성
		MyCalculator c1 = new MyCalculator();
		c1.add(2, 3);
		// 두 번째 방법 -익명 클래스를 통해 인라인 형태로 객체 생성

		Calculator c2 = new Calculator() {
			private  int sum =0;

			@Override
			public int add(int a, int b) {
				return 0;
			}
		};
		c2.add(2, 3);

		// 세 번째 방법 - 람다 표현식 형태로 작성.
		Calculator c3 = (a, b) -> a + b; //화살표 함수 자체가 하나의 인스턴스이자 구현체
		System.out.println(c3.add(2,3));

		// 4 번째 방법 - 메서드 참조
		// Calculator 인터페이스에 선언된 추상 메서드말고 Java에서 이미 제공되는 방식인 (Integer.sum())으로 구현
		Calculator c4 = Integer::sum;

	}
}

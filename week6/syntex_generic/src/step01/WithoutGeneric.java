package step01;

/**
 * Generic 문법이 없을 경우,
 *
 * Generic 문법
 * List<String> list = new ArrayList<>();
 * <String> -> Generic
 * list 변수에는 문자열 타입만 요소로 들어갈 수 있음
 */
public class WithoutGeneric {

	public static void main(String[] args) {
		Box fruitBox = new Box();

		Apple apple = new Apple();
		// 박스에 사과 담기
		fruitBox.setApple(apple);

		// 사과 꺼내기
		System.out.println(fruitBox.getApple());

		// 박스에 바나나 담기(?)
		// 제약조건: Box 클래스 내부에 별도의 Banana라는 필드를 선언하면 안됨
		// 그 외에 다른 코드들은 변경 가능
		Banana banana = new Banana();

		fruitBox.setFruit(banana);

		// 박스에서 바나나 꺼내기
		System.out.println(fruitBox.getFruit());

		// 한계점 1: 직접 다운캐스팅 해야함
		Banana extractedBanana = (Banana) fruitBox.getFruit();

		// 한계점 2: 런타임 에러가 발생할 수 있음
		Apple extractedApple = (Apple) fruitBox.getFruit(); // 사과인줄 알았는데..
		System.out.println(extractedApple);

		// 한계점 3: 과일말고 다른 모든 객체들도 포함될 수 있음
		fruitBox.setFruit(new Cookie()); // 과일박스에 쿠키가 들어감
	}

}

class Cookie {

}

package dev.syntax.step11object;

/**
 * int hashcode() - 해시 함수 구현 로직 hashing, 데이터 관리 기법 중 하나, 대량의 데이터 보관 및 검색에 유용한 방식
 *
 * 찾고자 하는 값 입력 시 해당 값이 저장된 위치를 알려주는 해시코드(hashcode) 반환
 *
 * 일반적인 해시 알고리즘에서는 확률적으로 해시값이 같은 두 객체가 존재할 수도 있지만,
 * Object가 제공하는 hashcode()는 객체의 주소값을 이용하기 때문에 같은 객체가 존재할 수 없음
 */
public class Step03HashCode {

	public static void main(String[] args) {
		Milk m1 = new Milk(500);
		Milk m2 = new Milk(500);

		System.out.println(m1.equals(m2)); // 별도로 오버라이딩하지 않았기 때문에 서로 다른 주소값, false
		System.out.println(m1.hashCode());
		System.out.println(m2.hashCode());

		String cookie1 = new String("오레오");
		String cookie2 = new String("오레오");

		// String 클래스는 주소값이 아닌 문자열 값을 비교하도록 Object의 equals()를 이미 오버라이딩 해두었음
		System.out.println(cookie1.equals(cookie2));

		// 문자열 객체가 서로 다른 주소값인지 비교하기 위해서는?
		System.out.println(cookie1.hashCode());
		System.out.println(cookie2.hashCode());
		// -> hashCode() 역시 String에서는 문자열의 값이 같으면 같은 해시코드를 반환하도록 오버라이딩해두었기 때문에 같은 값이 나옴

		// 문자열 객체가 서로 다른 객체의 주소값인지 확인하기 위해서는 System.identityHashCode(Object obj) 사용
		System.out.println(System.identityHashCode(cookie1));
		System.out.println(System.identityHashCode(cookie2));

	}

}

// Milk.java
class Milk {
	int volume;

	public Milk(int volume) {
		super();
		this.volume = volume;
	}

}

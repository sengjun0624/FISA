package dev.syntax.step11object;

/**
 * 기본 시그니처(내부 구현코드)
 * public boolean equals(Object obj){
 *     return this===obj;
 * }
 * - equals를 재정의 하여 주소 값이 아닌 원시값을 비교하게 재정의해보자.
 */
public class Step02Equals {
	public static void main(String[] args) {
		Mouse m1 = new Mouse(5);
		Mouse m2 = new Mouse(5);

		System.out.println("m1의 주소값: " + m1);
		System.out.println("m2의 주소값: " + m2);

		// age 필드의 값이 같아도, 개별 인스턴스의 주소값이 다르므로 결과값은 다르다고 뜸.

		if (m1.equals(m2)) {
			System.out.println("m1과 m2가 같음");
		} else
			System.out.println("m1과 m2가 다르다");

		System.out.println(m1.equals(m2));
		Dog dog = new Dog(3);
		/* 1.  다른 클래스를 넣으면 에러발생
		System.out.println(m1.equals(dog));*/
		// 2. null을 넣으면 에러발생
		// System.out.println(m1.equals(null));

	}
}

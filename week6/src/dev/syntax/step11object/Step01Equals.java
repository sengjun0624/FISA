package dev.syntax.step11object;

public class Step01Equals {
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
		// System.out.println(m1==m2); // 참조형일때는 주소값을 비교
		// System.out.println(5==3); // 원시값일때는 값 자체를 비교
		m1 = m2;
		if (m1.equals(m2)) {
			System.out.println("m1과 m2가 같음");
		} else
			System.out.println("m1과 m2가 다르다");
	}
}

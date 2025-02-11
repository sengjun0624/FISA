package dev.syntax.step11object;

/*
String toString()
- 인스턴스의 메타 정보(주로 필드 값)를 문자열 형태로 제공

내부 구현 코드
public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
}
→ getClass(), hashCode()는 Object 클래스가 가진 메서드이기 때문에 바로 호출 가능
*/
public class Step04ToString {
	public static void main(String[] args) {
		Book book1 = new Book("위대한 개츠비", 5000);
		Book book2 = new Book("시지프스 신화", 7000);

		System.out.println(book1.toString());
		System.out.println(book1); // 출력문 내부에 참조변수 작성 시 암묵적으로 toString() 호출
		System.out.println(book2);

		//    → 클래스 명은 같으나, 해시코드 값은 서로 다름
		//    dev.syntax.oop.step07object.Book@58ceff1
		//    dev.syntax.oop.step07object.Book@7c30a502

		// toString() 오버라이딩 할 경우 원하는 포맷으로 필드값을 출력할 수 있도록 변경 가능

		// 문자열 클래스의 경우 문자열 값을 출력할 수 있도록 toString()이 이미 오버라이딩 되어 있음
		String str = new String("어떤 문자열");
		System.out.println(str);
		System.out.println(str.toString());
	}
}

class Book {
	String name;
	int price;

	public Book(String name, int price) {
		this.name = name;
		this.price = price;
	}

}

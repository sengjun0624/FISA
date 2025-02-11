package dev.syntax.step04settergetter;

public class Mouse {
	String name;
	int age;
	String color;

	public Mouse(String name, int age, String color) {
		this.name = name;
		this.age = age;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		if (color != "black")
			return "White Mickey";
		return color;
	}

	// 미키 마우스의 핵심 칼라인 검정색이 외부에 의해 변경이 가능해짐.
	// getter setter는 개발자가 의도한 부분 외에는 개방하지 않아야 함.
	public void setColor(String color) {
		this.color = color;
	}

	public static void main(String[] args) {
		Mouse mickey = new Mouse("Mickey", 26, "black");

		// 외부에서 칼라를 임의 변경
		mickey.setColor("white");

		// 시그니처 칼라를 잃어버림.
		System.out.println(mickey.getColor());

	}
}

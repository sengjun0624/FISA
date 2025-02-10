package dev.syntax.step11object;

public class Mouse {
	int age;

	public Mouse(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return String.format("%d살 입니다.", this.age);
	}
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Mouse){
			return this.age == ((Mouse)o).age;
		}else return false;
	}
}

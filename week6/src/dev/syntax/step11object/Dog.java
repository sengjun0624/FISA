package dev.syntax.step11object;

public class Dog {
	int age;

	public Dog(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Dog){
			return this.age == ((Dog)o).age;
		}else return false;
	}
}

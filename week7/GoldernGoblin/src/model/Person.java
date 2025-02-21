package model;

public class Person {
	String name;

	Gender gender;

	public Person(String name, Gender gender) {
		this.name = name;
		this.gender = gender;
	}


	public Gender getGender() {
		return gender;
	}

}

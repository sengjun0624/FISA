package model;

public class Order {
	Person person;

	int amount;

	public Order(Person person, int amount) {
		this.person = person;
		this.amount = amount;
	}

	public Person getPerson() {
		return person;
	}

	public int getAmount() {
		return amount;
	}
}

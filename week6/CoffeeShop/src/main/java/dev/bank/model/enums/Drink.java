package dev.bank.model.enums;

public enum Drink {
	아메리카노(2000),
	라떼(2500);
	private int price;

	Drink(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
}

package dev.bank.parser;

import dev.bank.model.enums.Drink;

public class DrinkParser {
	public static Drink parseDrink(int type) {
		if (type == 1)
			return Drink.아메리카노;
		else if (type == 2) {
			return Drink.라떼;
		}
		else return null;

	}
}

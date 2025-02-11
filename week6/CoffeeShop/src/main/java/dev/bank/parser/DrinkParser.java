package dev.bank.parser;

import dev.bank.model.enums.Drink;

public class DrinkParser {
	public static Drink parseDrink(int type) {
		if(type==1)
			return Drink.아메리카노;
		else
			return Drink.라떼;
	}
}

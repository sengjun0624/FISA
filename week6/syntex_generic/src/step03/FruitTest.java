package step03;

import java.util.HashMap;

public class FruitTest {
	public static void main(String[] args) {
		FruitBox<Fruit, Integer> fruitBox = new FruitBox<>(new HashMap<>());
		Apple apple = new Apple();
		fruitBox.addFruitBox(apple, 2);
		Banana banana = new Banana();
		fruitBox.addFruitBox(banana, 2);

		System.out.println(fruitBox.getFruitBox(apple));
		System.out.println(fruitBox.getFruitBox(banana));

	}
}

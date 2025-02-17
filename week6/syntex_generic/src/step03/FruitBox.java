package step03;

import java.util.Map;

public class FruitBox<K, V> {
	private Map<K, V> fruitBox;

	public FruitBox(Map<K, V> fruitBox) {
		this.fruitBox = fruitBox;
	}

	public V getFruitBox(K fruitType) {
		return fruitBox.get(fruitType);
	}

	public void addFruitBox(K fruitType, V amount) {
		fruitBox.put(fruitType, amount);
	}
}


package step02;

import step01.Apple;
import step01.Banana;

public class FirstGeneric {
	public static void main(String[] args) {
		OnlyOneTypeBox<Apple> appleBox = new OnlyOneTypeBox<>();

		appleBox.set(new Apple()); //장점 1. 실수로라도 다른 타입을 세팅할 수 없음.

		Apple apple = appleBox.get();

		System.out.println(appleBox);

		OnlyOneTypeBox<Banana> bananaBox = new OnlyOneTypeBox<>();


	}
}

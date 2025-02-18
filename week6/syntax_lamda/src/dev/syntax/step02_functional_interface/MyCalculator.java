package dev.syntax.step02_functional_interface;

import dev.syntax.step01_lamda.Calculator;

public class MyCalculator implements Calculator {

	@Override
	public int add(int a, int b) {
		return a + b;
	}
}


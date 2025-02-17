package dev.bank.validator;

public class InputValidator {
	public static boolean validateNumber(int  input) {
		return input >= 1 && input < 3;
	}

	public static boolean validateAnswer(String answer) {
		return answer.equals("Yes") || answer.equals("No");
	}

}

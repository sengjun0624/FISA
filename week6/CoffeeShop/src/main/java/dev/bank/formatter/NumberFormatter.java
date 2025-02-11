package dev.bank.formatter;

public class NumberFormatter {
	public static String formatNumber(long number) {
		return String.format("%,d", number);
	}
}

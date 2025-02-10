package dev.bank;

public class BankStatementAnalyzerSimpleV5 {
	private static final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();

	public static void main(String[] args) {
		bankStatementAnalyzer.analyze("bank-data.txt");
		System.out.println();
		bankStatementAnalyzer.analyze("bank-data.csv");

	}
}

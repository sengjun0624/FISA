package dev.bank;

public class MainApplication {

	public static void main(String[] args) {
		// 입출금 분석기 생성(IDE 실행용 클래스)
		// BankStatementAnalyzer analyzer = new BankStatementAnalyzer();

		// jar 실행용 클래스
		BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
		analyzer.analyze(args[0]); // ex. args = "bank-data.txt"
	}

}


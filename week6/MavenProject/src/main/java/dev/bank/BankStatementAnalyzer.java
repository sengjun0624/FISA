package dev.bank;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import dev.bank.model.BankTransaction;
import dev.bank.parser.BankStatementCSVParser;
import dev.bank.parser.BankStatementParser;
import dev.bank.parser.BankStatementTSVParser;
import dev.bank.service.BankStatementProcessor;

public class BankStatementAnalyzer {
	private static final String RESOURCES = "src/main/resources/csv/";

	private static BankStatementParser parser = null;
	private static BankStatementProcessor bankService = null;

	public void analyze(String fileName) {
		final Path PATH = Paths.get(RESOURCES + fileName);
		parser = (fileName.contains("txt")) ? new BankStatementTSVParser() : new BankStatementCSVParser();

		try {
			List<String> lines = Files.readAllLines(PATH);

			List<BankTransaction> bankTransactions = parser.parseLinesFrom(lines);

			bankService = new BankStatementProcessor(bankTransactions);

			String result = String.format("총 입출금액은 %d원 입니다.", bankService.calculateTotal());
			System.out.println(result);

			String resultforMontb = String.format("1월의 입출금액은 %d원 입니다.",bankService.calculateTotalInMonth(Month.JANUARY));
			System.out.println(resultforMontb);

		} catch (Exception e) {
			System.out.println("입출금 내역 파일이 존재하지 않습니다.");
			e.printStackTrace();
		}
	}
}

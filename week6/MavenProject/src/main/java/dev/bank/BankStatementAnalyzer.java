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
	// private static final String RESOURCES = "~/Desktop/temp/FISA/week6/MavenProject/src/main/resources/csv/";
	private static final String RESOURCES = "/resources/";

	private static BankStatementParser parser = null;
	private static BankStatementProcessor bankService = null;

	public void analyze(String fileName) {
		final Path path = Paths.get(RESOURCES + fileName);
		parser = (fileName.contains("txt")) ? new BankStatementTSVParser() : new BankStatementCSVParser();
		System.out.println(parser);

		try {
			List<String> lines = Files.readAllLines(path);
			System.out.println(lines);
			String regex = (parser instanceof BankStatementCSVParser) ? "," : "\t";
			List<BankTransaction> bankTransactions = parser.parseLinesFrom(lines,regex);

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

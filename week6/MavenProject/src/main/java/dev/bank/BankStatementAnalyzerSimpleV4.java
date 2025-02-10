package dev.bank;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

import dev.bank.model.BankTransaction;
import dev.bank.parser.BankStatementCSVParser;
import dev.bank.parser.BankStatementParser;
import dev.bank.parser.BankStatementTSVParser;
import dev.bank.service.BankStatementProcessor;

/**
 *
 * @ TODO (BankStatementAnalyzerSimple의 관심사)
 * 1. 입출금 내역 파일 읽어들이기
 * 2. 전체 입출금 내역 조회
 * 3. 콘솔로 입출금 내역 결과 출력
 *//*
 */



public class BankStatementAnalyzerSimpleV4 {

	private static final String RESOURCES = "src/main/resources/csv/";

	private static BankStatementParser parser = null;
	private static BankStatementProcessor bankService = null;
	private static final Path PATH = Paths.get(RESOURCES + "bank-data.txt");

	public static void main(String[] args) {
		// Step 1 : 입출금 내역 파일 읽어들이기 (.csv파일 이라고 가정)
		try {
			// 1-2. 실제 파일 읽기, Files 객체를 통해
			List<String> lines = Files.readAllLines(PATH);
			if (lines.isEmpty())
				throw new Exception("입출금 내역이 존재하지 않습니다.");

			// Step 2 :전체 입출금 내역 조회

			// CSV일 경우,
			// List<BankTransaction> bankTransactionsCSV = csvParser.parseLinesFrom(lines);
			// TSV일 경우,
			parser = new BankStatementTSVParser();

		/*	if (args[0].contains("txt")) {
			} else
				parser = new BankStatementCSVParser();*/

			List<BankTransaction> bankTransactionsTSV = parser.parseLinesFrom(lines);
			bankService = new BankStatementProcessor(bankTransactionsTSV);

			String result = String.format("총 입출금액은 %d원 입니다.", bankService.calculateTotal());
			System.out.println(result);

			String resultforMontb = String.format("1월의 입출금액은 %d원 입니다.",bankService.calculateTotalInMonth(Month.JANUARY));
			System.out.println(resultforMontb);
		} catch (Exception e) {
			System.out.println("입출금 내역 파일이 존재하지 않습니다.");
			e.printStackTrace();

		}

		// Step 3 : 콘솔로 입출금 내역 결과 출력
	}

}


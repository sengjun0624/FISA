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

/**
 *
 * @ TODO (BankStatementAnalyzerSimple의 관심사)
 * 1. 입출금 내역 파일 읽어들이기
 * 2. 전체 입출금 내역 조회
 * 3. 콘솔로 입출금 내역 결과 출력
 */

public class BankStatementAnalyzerSimpleV3 {
	private static final String RESOURCES = "src/main/resources/csv/";

	// private static final BankStatementParser csvParser = new BankStatementCSVParser();
	private static final BankStatementParser tsvParser = new BankStatementTSVParser();

	// 1-1. 파일을 읽기 위해서는 해당 경로에 대한 정보가 필요
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
			List<BankTransaction> bankTransactionsTSV = tsvParser.parseLinesFrom(lines);

			String result = String.format("총 입출금액은 %d원 입니다.",calculateTotal(bankTransactionsTSV) );
			System.out.println(result);
			calculateTotalInMonth(bankTransactionsTSV,Month.JANUARY);

		} catch (Exception e) {
			System.out.println("입출금 내역 파일이 존재하지 않습니다.");
			e.printStackTrace();

		}

		// Step 3 : 콘솔로 입출금 내역 결과 출력
	}
	private static void calculateTotalInMonth(List<BankTransaction> bankTransactions,Month month) {
		long ret = 0L;
		for(BankTransaction bankTransaction : bankTransactions){

			if(bankTransaction.getDate().getMonth()==month)ret += bankTransaction.getAmount();
		}
		String resultForMonth = String.format("%s의 입출금액은 %d원 입니다.",month, ret );
		System.out.println(resultForMonth);
	}
	private static long calculateTotal(List<BankTransaction> bankTransactions) {
		long ret = 0L;
		for(BankTransaction bankTransaction : bankTransactions){
			ret += bankTransaction.getAmount();
		}

		return ret;
	}
}

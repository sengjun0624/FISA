/*
package dev.bank;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import dev.bank.model.BankTransaction;
import dev.bank.parser.BankStatementCSVParser;

*/
/**
 *
 * @ TODO (BankStatementAnalyzerSimple의 관심사)
 * 1. 입출금 내역 파일 읽어들이기
 * 2. 전체 입출금 내역 조회
 * 3. 콘솔로 입출금 내역 결과 출력
 *//*


public class BankStatementAnalyzerSimple {
	private static final String RESOURCES = "src/main/resources/csv/";
	private static final BankStatementCSVParser parser = new BankStatementCSVParser();


	public static void main(String[] args) {
		// Step 1 : 입출금 내역 파일 읽어들이기 (.csv파일 이라고 가정)
		// 1-1. 파일을 읽기 위해서는 해당 경로에 대한 정보가 필요
		final Path path = Paths.get(RESOURCES + "bank-data.csv");
		// 1-2. 실제 파일 읽기, Files 객체를 통해
		try {
			List<String> lines = Files.readAllLines(path);

			if (lines.isEmpty()) {
				throw new Exception("입출금 내역이 존재하지 않습니다.");
			}
			List<BankTransaction> bankTransactions = parser.parseLinesFrom(lines);




			// Step 2 :전체 입출금 내역 조회
			// String resultForMonth = String.format("1월의 입출금액은 %d원 입니다.", findTransactionsInJanuary(lines));
			// System.out.println(resultForMonth);

		} catch (Exception e) {
			System.out.println("입출금 내역 파일이 존재하지 않습니다.");
			e.printStackTrace();
		}

		// Step 3 : 콘솔로 입출금 내역 결과 출력
	}

}
*/

package dev.bank;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @ TODO (BankStatementAnalyzerSimple의 관심사)
 * 1. 입출금 내역 파일 읽어들이기
 * 2. 전체 입출금 내역 조회
 * 3. 콘솔로 입출금 내역 결과 출력
 */

public class BankStatementAnalyzerSimple {
	public static void main(String[] args) {
		// Step 1 : 입출금 내역 파일 읽어들이기 (.csv파일 이라고 가정)
		// 1-1. 파일을 읽기 위해서는 해당 경로에 대한 정보가 필요
		final Path path = Paths.get("src/main/resources/csv/" + "bank-data.csv");
		System.out.println(path);
		// 1-2. 실제 파일 읽기, Files 객체를 통해
		try {
			List<String> lines = Files.readAllLines(path);
			if (lines.isEmpty()) {
				throw new Exception("입출금 내역이 존재하지 않습니다.");
			}
			long total = 0L;

			for (String line : lines) {
				String[] columns = line.split(",");
				long amount = Long.parseLong(columns[2]);
				total += amount;
			}

			String result= String.format("총 입출금액은 %d원 입니다." ,total);
			System.out.println(result);

		} catch (Exception e) {
			System.out.println("입출금 내역 파일이 존재하지 않습니다.");
			e.printStackTrace();

		}
		// Step 2 :전체 입출금 내역 조회

		// Step 3 : 콘솔로 입출금 내역 결과 출력
	}
}

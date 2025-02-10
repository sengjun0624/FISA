package dev.bank.parser;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dev.bank.model.BankTransaction;

/**
 * dev.bank.pareser 패키지 - 읽어들인 파일 데이터에 대한 확장자별 변환 처리를 담당할 클래스만을 모아둔 패키지
 *
 * BankStatementCSVParser - 읽어들인 CSV 파일을 Java 프로그램에서 사용할 수 있도록 변환 처리 역할 수행
 */
public class BankStatementCSVParser implements BankStatementParser {
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	/**
	 *
	 * @param lines
	 * @return List<BankTransaction>
	 */
	@Override
	public List<BankTransaction> parseLinesFrom(List<String> lines) {
		// 하나 하나 조회해서 객체 생성해서 배열로 만든다.
		List<BankTransaction> result = new ArrayList<>();
		for(String line: lines){
			String[] columns = line.split(",");
			BankTransaction bankTransaction = new BankTransaction(LocalDate.parse(columns[0], DATE_PATTERN), columns[1],
				Long.parseLong(columns[2]));
			result.add(bankTransaction);
		}

		return result;
	}

}

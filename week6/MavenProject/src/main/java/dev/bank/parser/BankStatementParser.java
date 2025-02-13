package dev.bank.parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dev.bank.model.BankTransaction;

public interface BankStatementParser {
	static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	default List<BankTransaction> parseLinesFrom(List<String> lines,String regex){
		// 하나 하나 조회해서 객체 생성해서 배열로 만든다.
		List<BankTransaction> result = new ArrayList<>();
		for(String line: lines){
			String[] columns = line.split(regex);
			BankTransaction bankTransaction = new BankTransaction(LocalDate.parse(columns[0], DATE_PATTERN), columns[1],
				Long.parseLong(columns[2]));
			result.add(bankTransaction);
		}

		return result;
	}

}

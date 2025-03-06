package dev.bank.parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import dev.bank.model.BankTransaction;

@Component
public class BankStatementCSVParser implements BankStatementParser {
	@Override
	public List<BankTransaction> parseLinesFrom(List<String> lines) {
		// 하나 하나 조회해서 객체 생성해서 배열로 만든다.
		List<BankTransaction> result = new ArrayList<>();
		for (String line : lines) {
			String[] columns = line.split(",");
			BankTransaction bankTransaction = new BankTransaction(LocalDate.parse(columns[0], DATE_PATTERN), columns[1],
				Long.parseLong(columns[2]));
			result.add(bankTransaction);
		}
		return result;
	}
}

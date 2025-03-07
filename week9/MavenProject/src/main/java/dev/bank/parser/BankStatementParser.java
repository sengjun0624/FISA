package dev.bank.parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dev.bank.model.BankTransaction;

public interface BankStatementParser {
	static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public List<BankTransaction> parseLinesFrom(List<String> lines);
}

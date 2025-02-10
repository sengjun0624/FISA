package dev.bank.parser;

import java.util.List;

import dev.bank.model.BankTransaction;

public interface BankStatementParser {
	List<BankTransaction> parseLinesFrom(List<String> lines);

}

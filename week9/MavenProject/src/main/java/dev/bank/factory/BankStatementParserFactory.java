package dev.bank.factory;

import dev.bank.parser.BankStatementCSVParser;
import dev.bank.parser.BankStatementParser;
import dev.bank.parser.BankStatementTSVParser;
import org.springframework.stereotype.Component;

@Component
public class BankStatementParserFactory {

	private final BankStatementCSVParser csvParser;
	private final BankStatementTSVParser tsvParser;

	public BankStatementParserFactory(BankStatementCSVParser csvParser, BankStatementTSVParser tsvParser) {
		this.csvParser = csvParser;
		this.tsvParser = tsvParser;
	}

	public BankStatementParser getParser(String fileName) {
		if (fileName.endsWith(".csv")) {
			return csvParser;
		} else if (fileName.endsWith(".tsv") || fileName.endsWith(".txt")) {
			return tsvParser;
		} else {
			throw new IllegalArgumentException("지원하지 않는 파일 형식: " + fileName);
		}
	}
}

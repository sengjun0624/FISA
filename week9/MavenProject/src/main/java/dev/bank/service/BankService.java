package dev.bank.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dev.bank.factory.BankStatementParserFactory;
import dev.bank.model.BankTransaction;
import dev.bank.parser.BankStatementParser;

/**
 * 프로그램의 핵심 로직이 담긴 부분 보통 service - 어떤 도메인에 해당되는 서비스 or 비즈니스
 *
 * service - 어떤 도메인에 해당되는 서비스 or 비즈니스
 */
@Component
public class BankService {
	private static final String RESOURCES = "src/main/resources/";
	private final BankStatementParserFactory parserFactory;

	List<BankTransaction> bankTransactions = new ArrayList<>();

	public BankService(BankStatementParserFactory parserFactory) {
		this.parserFactory = parserFactory;
	}

	public void analyze(String fileName) {
		try {
			List<String> lines = Files.readAllLines(Paths.get(RESOURCES + fileName));
			if (lines.isEmpty())
				throw new Exception("입출금 내역이 존재하지 않습니다.");

			BankStatementParser parser = parserFactory.getParser(fileName);

			bankTransactions = parser.parseLinesFrom(lines);

			String result = String.format("총 입출금액은 %d원 입니다.", this.calculateTotal());
			System.out.println(result);

			String resultforMontb = String.format("1월의 입출금액은 %d원 입니다.",
				this.calculateTotalInMonth(Month.JANUARY));
			System.out.println(resultforMontb);
		} catch (Exception e) {
			System.out.println("입출금 내역 파일이 존재하지 않습니다.");
			e.printStackTrace();
		}
	}

	private long calculateTotalInMonth(Month month) {
		long ret = 0L;
		for (BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month)
				ret += bankTransaction.getAmount();
		}
		return ret;
	}

	private long calculateTotal() {
		long ret = 0L;
		for (BankTransaction bankTransaction : bankTransactions) {
			ret += bankTransaction.getAmount();
		}
		return ret;
	}
}

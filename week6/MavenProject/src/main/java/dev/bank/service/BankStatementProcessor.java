package dev.bank.service;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import dev.bank.model.BankTransaction;

/**
 * 프로그램의 핵심 로직이 담긴 부분 보통 service - 어떤 도메인에 해당되는 서비스 or 비즈니스
 *
 * service - 어떤 도메인에 해당되는 서비스 or 비즈니스
 */
public class BankStatementProcessor {
	List<BankTransaction> bankTransactions = new ArrayList<>();

	public BankStatementProcessor(List<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}

	public long calculateTotalInMonth(Month month) {
		long ret = 0L;
		for (BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month)
				ret += bankTransaction.getAmount();
		}
		return ret;
	}

	public long calculateTotal() {
		long ret = 0L;
		for (BankTransaction bankTransaction : bankTransactions) {
			ret += bankTransaction.getAmount();
		}
		return ret;
	}
}

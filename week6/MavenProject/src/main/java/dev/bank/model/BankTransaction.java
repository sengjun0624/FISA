package dev.bank.model;

import java.time.LocalDate;

/**
 * model 패키지 - 모델링한 결과 클래스들을 모아둔 패키지
 *
 * BankTransasction - 단 건 입출금 내역
 * ex. 2020-12-29,Costco,-152200`
 *
 * 입출금 내역 데이터 파일로부터 읽어들인 각각의 개별 데이터들을 하나의 의미있는 클래스로 추상화.
 */
public class BankTransaction {
	private LocalDate date;
	private String description;
	private Long amount;

	public BankTransaction(LocalDate date, String description, Long amount) {
		this.date = date;
		this.description = description;
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public Long getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "BankTransaction{" +
			"date=" + date +
			", description='" + description + '\'' +
			", amount=" + amount +
			'}';
	}
}

package dev.spring.annotation.domain;

import org.springframework.beans.factory.annotation.Value;

public class Tape {
	// Value를 사용해 필드에 값을 직접 주입

	@Value("아일랜드")
	private String name;
	@Value("true")
	private boolean isWorked;

	public Tape() {}

	public boolean isWorked() {
		return isWorked;
	}

	public String getName() {
		return name;
	}
}

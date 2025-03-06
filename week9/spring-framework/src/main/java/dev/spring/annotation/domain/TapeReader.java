package dev.spring.annotation.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class TapeReader {

	private Tape tape;

	@Autowired
	public TapeReader(Tape tape) {
		this.tape = tape;
	}

	public void test() {
		if (tape.isWorked()) {
			System.out.println(tape.getName() + " 잘 동작합니다");
		} else {
			System.out.println(tape.getName() + " 사기당했어요 ㅋㅋ");
		}
	}
}

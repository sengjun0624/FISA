package dev.spring.annotation.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class TapeReader {

	@Autowired
	private Tape tape;

	public TapeReader(){
		System.out.println("TapeReader() called");
	}
	public void test() {
		if (tape.isWorked()) {
			System.out.println(tape.getName() + " 잘 동작합니다");
		} else {
			System.out.println(tape.getName() + " 사기당했어요 ㅋㅋ");
		}
	}
}

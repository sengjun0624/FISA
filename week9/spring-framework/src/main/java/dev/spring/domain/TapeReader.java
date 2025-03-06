package dev.spring.domain;

public class TapeReader {
	private Tape tape;

	public TapeReader(Tape tape) {
		this.tape = tape;
	}

	public TapeReader() {
	}

	public void setTape(Tape tape1) {
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

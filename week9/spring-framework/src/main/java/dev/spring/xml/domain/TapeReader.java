package dev.spring.xml.domain;
public class TapeReader {

	private  Tape tape;

	public TapeReader(Tape tape) {
		System.out.println("TapeReader(Tape tape) called");
		this.tape = tape;
	}

	public void setTape(Tape tape) {
		this.tape = tape;
	}

	public TapeReader(){};
	public void test() {
		if (tape.isWorked()) {
			System.out.println(tape.getName() + " 정상 동작합니다.");
		} else {
			System.out.println(tape.getName() + " 사기 당했습니다.");
		}
	}

	// 팩토리 메서드를 통해 주입
	public static TapeReader createTapeReader(Tape tape) {
		// 다른 로직을 추가 작성 가능한 부분
		System.out.println("createTapeReader(Tape tape) called");
		return new TapeReader(tape);
	}

}

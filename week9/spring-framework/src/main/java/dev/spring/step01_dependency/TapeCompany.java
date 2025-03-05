package dev.spring.step01_dependency;

public class TapeCompany {
	public static TapeReader createTapeReader() {
		return new TapeReader();
	}

	public static Tape createTape() {
		return new Tape("아일랜드", true);
	}
}

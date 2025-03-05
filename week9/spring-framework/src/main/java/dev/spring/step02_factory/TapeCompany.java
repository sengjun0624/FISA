package dev.spring.step02_factory;

public class TapeCompany {
	public static TapeReader createTapeReader() {
		return new TapeReader();
	}

	public static Tape createTape() {
		return new Tape("아일랜드", true);
	}
}

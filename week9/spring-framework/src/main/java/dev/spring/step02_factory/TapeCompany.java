package dev.spring.step02_factory;

import dev.spring.domain.Tape;
import dev.spring.domain.TapeReader;

public class TapeCompany {
	public static TapeReader createTapeReader() {
		return new TapeReader();
	}

	public static Tape createTape() {
		return new Tape("아일랜드", true);
	}
}

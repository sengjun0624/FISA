package dev.spring.xml.step02_factory;

import dev.spring.xml.domain.Tape;
import dev.spring.xml.domain.TapeReader;

public class TapeCompany {
	public static TapeReader createTapeReader() {
		return new TapeReader();
	}

	public static Tape createTape() {
		return new Tape("아일랜드", true);
	}
}

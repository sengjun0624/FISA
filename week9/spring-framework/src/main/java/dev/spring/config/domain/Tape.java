package dev.spring.config.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Tape {

	private String name;
	private boolean isWorked;

	// @Autowired
	public Tape(String name, boolean isWorked) {
		super();
		this.name = name;
		this.isWorked = isWorked;
	}

	public String getName() {
		return name;
	}

	public boolean isWorked() {
		return isWorked;
	}

}

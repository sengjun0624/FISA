package dev.spring.domain;

public class Tape {
	private String name;
	private boolean isWorked;

	public Tape() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWorked(boolean worked) {
		isWorked = worked;
	}

	public Tape(String name, boolean isWorked) {
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

package dev.spring.xml.domain;

public class Tape {
	private String name;
	private boolean isWorked;

	public Tape() {

	}

	public Tape(String name, boolean isWorked) {
		this.name = name;
		this.isWorked = isWorked;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWorked(boolean worked) {
		isWorked = worked;
	}

	public String getName() {
		return name;
	}

	public boolean isWorked() {
		return isWorked;
	}
}

package dev.jpa.dto;

import dev.jpa.model.Student;

// Student 엔티티에 대한 결과 데이터를 임시로 담아두는 클래스
public class StudentData {
	private int id;
	private String name;

	public StudentData(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// 정적 팩토리 메서드
	public static StudentData from(Student student) {
		final int id = student.getId();
		final String name = student.getName();
		return new StudentData(id, name);
	}

	@Override
	public String toString() {
		return "StudentData [id=" + id + ", name=" + name + "]";
	}

}

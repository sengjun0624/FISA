package dev.jpa.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dev.jpa.model.Major;

public class MajorData {
	private int id;
	private String name;
	private List<StudentData> students = new ArrayList<>();

	// 정적 팩토리 메서드

	public MajorData(int id, String name, List<StudentData> students) {
		this.id = id;
		this.name = name;
		this.students = students;
	}

	public static MajorData from(Major major) {
		// 파라미터의 인수로 전달받은 Major 엔티티에 담긴 값들을 하나씩 추출, MajorData필드에 할당
		final int id = major.getId(); // 임시 변수
		final String name = major.getName();


		// 학생 데이터 추출
		List<StudentData> students = major.getStudents().stream()
			.map(student -> StudentData.from(student))
			.collect(Collectors.toList());
		return new MajorData(id,name,students);
	}
}

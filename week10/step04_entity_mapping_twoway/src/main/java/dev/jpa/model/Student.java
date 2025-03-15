package dev.jpa.model;

import lombok.*;

import javax.persistence.*;

// @ToString
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "major_Id")
	private Major major;

	// 연관관계 매핑용 편의 메서드를 활용하여 리팩토링 테스트 검증용 메서드
	// public void setMajor(Major major) {
	//     this.major = major;
	// }
	public void setMajor(Major major) {
		// 기존 학과와의 관계 제거
		if (this.major != null) {
			this.major.getStudents().remove(this);
		}
		this.major = major;
		// 반대편 연관관계 매핑용 코드 추가
		major.getStudents().add(this);
	}

	@Override
	public String toString() {
		return "name" + name + major.getName();
	}
}

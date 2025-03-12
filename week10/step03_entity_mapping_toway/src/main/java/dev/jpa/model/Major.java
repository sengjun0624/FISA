package dev.jpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 전공은 여러 명의 학생을 포함

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
public class Major {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	/**
	 * DB는 FK만으로, 양쪽 테이블에서 조회가 가능하기 때문에, 양방향,단방향이라는 개념이 없음.
	 * 하지만, 객체 지향 모델링에서는 참조 필드를 지니고 있어야 연관관계에 접근이 가능함. 또한, 참조 필드가 서로 존재하면
	 * 어디서 정보를 수정할지를 고민해봐야함. Student와 Major가 N:1이면, Student에서 Major를 수정해야할지, Major에서 Stduent를 수정해야할지
	 * JPA는 헷갈리게 됨. ORM과 OOP 모델링의 패러다임 충돌의 예시이기도 하다.
	 * 연관관계의 주인이 되는 테이블은 FK를 가지는 테이블이 된다. 그래서, 연관관계의 주인이 되는 테이블이 주인이 되고, 연관관계의 주인이 아닌 객체에서
	 * mappedBy로 연관관계의 주인을 설정해주면 패러다임의 충돌을 해결 할 수 있다.
	 * 연관관계의 주인이 되는 테이블에서만 연관관계를 맺고, 수정,삭제,추가등 정보를 수정할 수 있으며
	 * 반대쪽 테이블은 조회만 가능하다.
	 *
	 * 무조건, 양방향 매핑이 좋은건가?
	 * 그건 아니다. 연관관계 매핑을 유지하기 위해선, 양쪽의 데이터를 관리해주어 하기 떄문에, 관리가 복잡해진다.
	 */
	@OneToMany(mappedBy = "major", cascade = CascadeType.PERSIST)
	List<Student> students = new ArrayList<>();

	public void addStudent(Student student) {
		this.students.add(student);
	}

}

package dev.jpa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.jpa.model.Major;
import dev.jpa.model.Student;

public class ToWayMappingTest {


	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("step03_entity_mapping_twoway"); // 한 번만 생성
	EntityManager em;
	EntityTransaction tx;

	@BeforeEach
	void setup() {
		em = factory.createEntityManager(); // 매 테스트마다 새로운 EntityManager 생성
		tx = em.getTransaction();  // 새로운 트랜잭션 객체 가져오기
	}
	@Test
	void 학생을_추가하면_학과에서도_조회할_수_있어야_한다() {
		tx.begin();

		// Major 생성
		Major major1 = Major.builder().name("Computer Science").students(new ArrayList<>()).build();
		em.persist(major1);

		// Student 생성
		Student student1 = Student.builder().name("이승준").build();
		Student student2 = Student.builder().name("노영재").build();

		major1.addStudent(student1);
		major1.addStudent(student2);

		student1.setMajor(major1);
		student2.setMajor(major1);

		// Major를 persist하면 students도 자동으로 저장된다.
		em.persist(major1);

		tx.commit();

		em.clear();

		Major foundMajor = em.find(Major.class, major1.getId());

		// 트랜잭션 내에서 학생 리스트 조회 (Lazy Loading 문제 방지)
		List<Student> students = foundMajor.getStudents();

		assertEquals(2, students.size());
		assertEquals("이승준", students.get(0).getName());
		assertEquals("노영재", students.get(1).getName());
	}
	@Test
	@DisplayName("연관관계의_주인_객체는_FK_관계를_맺을_수_있다")
	void 연관관계의_주인_객체는_FK_관계를_맺을_수_있다(){
		// given
		Major major = Major.builder().name("휴먼지능정보공학과").students(new ArrayList<>()).build();
		Student student = Student.builder().name("이원빈").build();
		tx.begin();
		em.persist(student);
		em.persist(major);

		//when
		student.setMajor(major);
		tx.commit();

		// then
		Student foundStudent = em.find(Student.class, student.getId());
		assertNotNull(foundStudent.getMajor(), "연관관계의 주인이 아닌 Major가 Student와 관계를 맺으면 FK가 반영되지 않아야 한다.");
	}
	@Test
	@DisplayName("연관관계의 주인이 아닌  객체는 FK 관계를 맺을 수 없다")
	void 연관관계의_주인이아닌_객체는_FK_관계를_맺을_수_없다(){

		// given
		Major major = Major.builder().name("휴먼지능정보공학과").students(new ArrayList<>()).build();
		Student student = Student.builder().name("이원빈").build();
		tx.begin();
		em.persist(student);
		em.persist(major);

		//when
		major.addStudent(student);
		tx.commit();

		// then
		Student foundStudent = em.find(Student.class, student.getId());
		// FK가 설정되지 않았기 때문에 null이어야 함
		Major major2 = foundStudent.getMajor();
		assertNull(major2, "연관관계의 주인이 아닌 Major가 Student와 관계를 맺으면 FK가 반영되지 않아야 한다.");
	}
	@Test
	@DisplayName("양방향 연관관계에서 toString()을 호출하면 StackOverflowError가 발생한다.")
	void 양방향_연관관계에서_toString을_호출하면_순환참조가_발생한다() {
		// given
		Major major = new Major();
		major.setName("휴먼지능정보공학과");
		major.setStudents(new ArrayList<>());

		Student student = new Student();
		student.setName("이원빈");

		// 양방향 관계 설정
		major.addStudent(student);
		student.setMajor(major);

		// when & then
		Assertions.assertThrows(StackOverflowError.class, () -> {
			System.out.println(student.toString());
		});
	}
}

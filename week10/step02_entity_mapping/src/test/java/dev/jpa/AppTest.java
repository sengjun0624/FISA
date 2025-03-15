package dev.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.jpa.model.Major;
import dev.jpa.model.Student;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02_entity_maping");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();

	@Test
	@DisplayName("두 엔티티 (Student,Major) 간의 연관관계 매핑 후 저장 테스트")
	void testSave() {
		// given
		// 학과 데이터 생성 저장, DB에 저장 (영속화)
		tx.begin();
		Major 컴퓨터공학과 = Major.builder().name("컴퓨터공학과").build();
		Student 이승준 = Student.builder().name("이승준").build();

		//when
		// 학생 1 생성, 저장
		em.persist(컴퓨터공학과);
		이승준.setMajor(컴퓨터공학과);
		em.persist(이승준);

		tx.commit();
	}

	@Test
	@DisplayName("조회된 학생 엔티티를 통해 해당 학생의 전공이 무엇인지 확인할 수 있다.")
	void findRelation() {
		// given
		String expected = "컴퓨터공학과";

		// when
		Student student = em.find(Student.class, 1);
		String actual = student.getMajor().getName();

		// then
		Assertions.assertEquals(expected, actual);
	}

	@Test
	@DisplayName("조회된 학생의 전공을 다른 전공으로 변경할 수 있다.")
	void updateRelation() {
		// given
		Major expected = Major.builder().name("전자공학과").build();

		// when
		tx.begin();
		Student student = em.find(Student.class, 1);
		student.setMajor(expected);
		tx.commit();

		// then
		Student student1 = em.find(Student.class, 1);
		Assertions.assertEquals(expected, student1.getMajor());
	}
}

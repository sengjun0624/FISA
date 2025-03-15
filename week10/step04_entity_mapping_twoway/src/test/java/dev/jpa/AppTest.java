package dev.jpa;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.jpa.dto.MajorData;
import dev.jpa.model.Major;
import dev.jpa.model.Student;

public class AppTest {

    EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("step04_entity_mapping_twoway");

    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();

    @Test
    void 양방향_연관관계_저장() {
        //given
        tx.begin();
        Major major = Major.builder().name("컴퓨터 공학").build();
        // 학과 영속화
        em.persist(major);
        // 학생 1 생성 저장, 전공을 CS로 저장
        Student yoo = Student.builder().name("YOO").build();

        //when && then
        yoo.setMajor(major);
        //EM은 이곳에 입력된 값을 통해 외래키를 관리함.
        em.persist(yoo);
        tx.commit();

    }

    @Test
    void 양방향_연관관계_외래키_설정_미흡() {
        tx.begin();
        // 학과 데이터 생성
        Major ko = Major.builder().name("국문학과").build();

        // 학과 데이터 영속화(저장)
        em.persist(ko);

        // 학생 1 생성, 저장
        Student kang = Student.builder().name("KANG").build();

        // 연관관계의 주인이 아닌 쪽(외래키를 가지지 않은 쪽)에 연관관계(외래키)를 설정하였을 경우,
        ko.getStudents().add(kang);

        em.persist(kang);

        tx.commit();
        /*
        -> KANG 학생이 국문학과인 2번으로 매핑이 되지 않았음
        외래키를 관리하는 연관관계의 주인인 Student.major에 별도의 값을 입력하지 않았기 때문에
        MAJOR_ID의 값도 null로 설정되었음
         */
    }

    @Test
    void 양방향_연관관계_조회() {
    }

    @Test
    void 양방향_연관관계_중_객체_패러다임에서_연관관계_설정이_미흡한_경우() {
        // 연관관계의 주인에'만' 값을 설정하는 양방향 연관관계의 외래키 설정은 객체 패러다임으로 올 경우 문제가 생길 수 있음
        // jpa 없이 객체 지향 코드로만 작성한 케이스

        Major cs = Major.builder().name("컴퓨터 공학").build();

        // 학생 2명 생성
        Student yoo = Student.builder().name("YOO").build();
        Student kang = Student.builder().name("KANG").build();

        yoo.setMajor(cs); // 학생에게 학과 연관관계 설정(student -> major)
        kang.setMajor(cs);

        System.out.println("yoo.getMajor() = " + yoo.getMajor()); // CS

        // 컴공과에 속한 학생 목록 조회
        List<Student> students = cs.getStudents();
        System.out.println("students = " + students); // []
        // -> JPA를 사용하지 않는 객체 맥락에서 외래키의 반대 방향은 연관관계를 설정하지 않았기 때문에
        // 학생 목록이 없는 빈 배열이 출력됨

        // then
        Assertions.assertEquals(0, students.size()); // 전공 생성

    }

    @Test
    void 양방향_연관관계_중_객체_패러다임에서_연관관계_설정을_양쪽_모두_적용한_경우() {
        Major cs = Major.builder().name("컴퓨터 공학").build();

        // 학생 2명 생성
        Student yoo = Student.builder().name("YOO").build();
        Student kang = Student.builder().name("KANG").build();

        yoo.setMajor(cs); // 학생에게 학과 연관관계 설정(student -> major)
        kang.setMajor(cs);

        System.out.println("yoo.getMajor() = " + yoo.getMajor()); // CS

        // 양 방향 매핑 추가
        cs.addStudent(yoo);
        cs.addStudent(kang);

        // 컴공과에 속한 학생 목록 조회
        List<Student> students = cs.getStudents();
        // -> JPA를 사용하지 않는 객체 맥락에서 외래키의 반대 방향은 연관관계를 설정하지 않았기 때문에
        // 학생 목록이 없는 빈 배열이 출력됨

        // then
        Assertions.assertEquals(2, students.size());
    }

    @Test
    void 양방향_연관관계_중_JPA_관계형_패러다임과_객체_패러다임에서_연관관계_설정을_양쪽_모두_적용한_경우() {
        tx.begin();

        // 학과 데이터 생성 및 저장
        Major cs = Major.builder().name("컴퓨터 공학").build();
        em.persist(cs);

        // 학생 1 생성 및 저장
        Student yoo = Student.builder().name("YOO").build();
        yoo.setMajor(cs); // 학생에게 학과 등록, 연관관계 설정 student -> major
        cs.getStudents().add(yoo);// 학과에 학생 등록, 연관관계 설정 major -> student, 연관관계의 주인이 아니며, 저장 시 사용되진 않음, 객체 패러다임에서 사용하기 위해 저장
        em.persist(yoo);

        // 학생 2 생성 및 저장
        Student kang = Student.builder().name("KANG").build();
        kang.setMajor(cs); // 학생에게 학과 등록, 연관관계 설정 student -> major
        cs.getStudents().add(kang);// 학과에 학생 등록, 연관관계 설정 major -> student
        em.persist(kang);

        tx.commit();
    }

    @Test
    void 연관관계_매핑용_편의_메서드를_활용하여_리팩토링() {
        tx.begin();

        // 학과 데이터 생성 및 저장
        Major cs = Major.builder().name("컴퓨터 공학").build();
        em.persist(cs);

        // 학생 1 생성 및 저장
        Student yoo = Student.builder().name("YOO").build();
        yoo.setMajor(cs); // 학생에게 학과 등록, 연관관계 설정 student -> major
        cs.getStudents().add(yoo);// 학과에 학생 등록, 연관관계 설정 major -> student, 연관관계의 주인이 아니며, 저장 시 사용되진 않음, 객체 패러다임에서 사용하기 위해 저장
        em.persist(yoo);

        // 학생 2 생성 및 저장
        Student kang = Student.builder().name("KANG").build();
        kang.setMajor(cs); // 학생에게 학과 등록, 연관관계 설정 student -> major
        em.persist(kang);

        tx.commit();
    }

    @Test
    void 학생의_학과_변경_테스트_에러_케이스() {
        Major cs = Major.builder().name("컴퓨터 공학").build();
        Major ko = Major.builder().name("국어 국문").build();

        Student yoo = Student.builder().name("YOO").build();
        yoo.setMajor(cs); // 컴공 진학
        yoo.setMajor(ko); // 변덕으로 국문학과로 변경

        List<Student> students = cs.getStudents();
        System.out.println(students.get(0).getName()); // cs에 왜 니가?

        // 컴공에서 안 빼줬잖아;

    }

    @Test
    void 학생의_학과_변경_테스트_해결() {
        Major cs = Major.builder().name("컴퓨터 공학").build();
        Major ko = Major.builder().name("국어 국문").build();

        Student yoo = Student.builder().name("YOO").build();
        yoo.setMajor(cs); // 컴공 진학
        yoo.setMajor(ko); // 변덕으로 국문학과로 변경

        List<Student> students = cs.getStudents();
        if(!students.isEmpty())System.out.println(students.get(0).getName()); // cs에 왜 니가?
        else
            System.out.println("cs학과는 비어있음");
        // 컴공에서 안 빼줬잖아;

    }

    @Test
    void 순환_참조_문제() {
    }

    @Test
    void 순환_참조_해결() {
        Major cs = em.find(Major.class, 1);
        MajorData csData = MajorData.from(cs); // DB에서 반환된 Entity를 DTO 타입으로 변환

        System.out.println(csData);
    }

}

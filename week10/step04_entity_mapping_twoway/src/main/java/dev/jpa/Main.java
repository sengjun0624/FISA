package dev.jpa;

import dev.jpa.model.Major;
import dev.jpa.model.Student;

public class Main {
    public static void main(String[] args) {
        // 일반적인 객체 지향 문법으로 작성(JPA 없이)

        Student 승한 = Student.builder().id(1).name("승한").build();

        Major 산공 = Major.builder().name("산공").build();

        // 승한님을 산업공학과에 입과
        승한.setMajor(산공);

        // 객체 모델에서 승한님이 속한 학과를 조회?
        Major major = 승한.getMajor();
        System.out.println("major = " + major);
    // -> 객체 지향 모델에서는 참조 연산자(dot, .기호)를 사용해서 객체들 간의 연관관계를 탐색할 수 있음
    }
}

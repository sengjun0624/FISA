package dev.jpa.model;

public class Main {
	public static void main(String[] args) {
		Student 승한 = Student.builder().id(1).name("승한").build();
		Major 산공 = Major.builder().name("산공").build();

		// 승한님을 산업공학과에 입과
		승한.setMajor(산공);

		System.out.println(승한.getMajor());


	}
}

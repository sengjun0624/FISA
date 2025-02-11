package dev.syntax.step08practice;

/**
 * 학생이 버스에 탑승해서 통근할 수 있는 애플리케이션
 *
 * 학생은 버스에 탑승할 수 있고, 요금을 지불해야 함
 * 버스는 학생을 받아서 요금을 받을 수 있다.
 *
 */
public class CommutingApplication {

	public static void main(String[] args) {
		Student newSpring = new Student("새봄", 10000);

		Vehicle bus = new Bus(101);
		Vehicle subway = new Subway(102);
		newSpring.take(bus);
		newSpring.take(subway);
		// 상태 확인

		newSpring.printInfo();
		System.out.println(bus.toString());
		System.out.println(subway.toString());

	}
}
//;



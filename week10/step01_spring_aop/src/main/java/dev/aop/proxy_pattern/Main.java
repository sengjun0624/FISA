package dev.aop.proxy_pattern;

import org.springframework.beans.factory.annotation.Autowired;

public class Main {

	public static void main(String[] args) {
		// GreetingService greetingService = new GreetingServiceImpl();
		// greetingService.sayHello();
		// 프록시 사용 후
		GreetingService greetingService2 = new GreetingServiceProxy();
		greetingService2.sayHello(); // "Say? Hello!!" 출력
	}

	static interface GreetingService {
		void sayHello();
	}

	static class GreetingServiceImpl implements GreetingService {
		@Override
		public void sayHello() {
			System.out.println("Hello!!");
		}
	}
	// 프록시 클래스
	static class GreetingServiceProxy implements GreetingService {
		private GreetingServiceImpl target;

		// Proxy 클래스도 GreetingService 인터페이스를 구현
		@Override
		public void sayHello() {
			// sayHello()가 실제로 호출되기 전까지는 타겟 객체의 인스턴스 생성을 지연(Lazy initialization)
			if (target == null) {
				target = new GreetingServiceImpl();
			}

			// 프록시가 수행할 부가 기능(동작)
			System.out.print("Say? ");

			// 프록시는 부가기능을 수행한 이후 실제 타겟 메서드 호출
			target.sayHello(); // Hello!!
		}
	}
}

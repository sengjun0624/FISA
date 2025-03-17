package dev.aop;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

		// SpringBoot가 아니기 때문에 의존성을 간단하게 해결
		ApplicationContext context
			= new ClassPathXmlApplicationContext("beans.xml");

		// AOP 적용 전, 출력 로직(로깅)을 Controller에서 분리하기 어려움
		// UserController controller = context.getBean(UserController.class);
		// controller.getUsers();

		// AOP 적용 후, 출력 로직(로깅)을 AOP를 통해 동작할 수 있도록 적용
		// UserController - 실제 호출을 수행하는 대상 객체(Target)
		// ProxyFactoryBean을 통해 생성된 객체를 프록시(Proxy), 타겟이 호출되기 전에
		// 클라이언트(Main.java)의 호출을 가로채서
		// 먼저 작업을 수행(수행되는 작업은 SimpleAdvice에 작성된 내용)
		UserController controller =
			(UserController) context.getBean("proxyFactoryBean");


		controller.getUsers(); // 프록시가 SimpleAdivce의 작업 수행 후 타겟 객체의 메서드인 getUsers() 호출


	}
}

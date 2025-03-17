package dev.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Method;

// 이후에 작성할 Aspect와 유사한 역할을 수행하는 클래스

public class SimpleAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

	/**
	 * MethodBeforeAdvice.java
	 * 대상 메서드(target),
	 * 여기서는 UserController가 호출되기 전에 실행할 내용을 작성할 수 있도록 제공하는 클래스
	 */
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// UserController가 호출되기 전에 동작시키고 싶은 코드 작성 부분
		System.out.println("UserController.getUser() 호출 전");
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		if (method.getName().equals("getUsers")) {
			System.out.println("users = " + returnValue);
		}
	}
}

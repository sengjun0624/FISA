package dev.aop.proxy_pattern;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class ProxyAdvice implements MethodBeforeAdvice {
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {

	}
}

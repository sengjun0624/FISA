package dev.spring.petclinic.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

	// 모든 서비스 메서드 실행 전후에 로그를 남기는 포인트컷
	@Pointcut("execution(* dev.spring.petclinic..*(..))")
	public void applicationPackagePointcut() {}

	@Before("applicationPackagePointcut()")
	public void logBefore(JoinPoint joinPoint) {
		log.debug("Before method: {} in {}", joinPoint.getSignature(), joinPoint.getTarget().getClass().getName());
	}

	@After("applicationPackagePointcut()")
	public void logAfter(JoinPoint joinPoint) {
		log.debug("After method: {} in {}", joinPoint.getSignature(), joinPoint.getTarget().getClass().getName());
	}
}

package dev.bank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.bank.config.BeanConfig;
import dev.bank.service.BankService;

public class MainApplication {

	public static void main(String[] args) {
		// 입출금 분석기 생성(IDE 실행용 클래스)
		new AnnotationConfigApplicationContext(BeanConfig.class).getBean(BankService.class).analyze(args[0]);
	}

}


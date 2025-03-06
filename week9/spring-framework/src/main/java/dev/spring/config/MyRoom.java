package dev.spring.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.spring.config.config.BeanConfig;
import dev.spring.config.domain.TapeReader;

public class MyRoom {
	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(BeanConfig.class).getBean(TapeReader.class).test();
	}


}

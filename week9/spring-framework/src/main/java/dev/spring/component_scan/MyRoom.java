package dev.spring.component_scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.spring.component_scan.domain.TapeReader;

public class MyRoom {
	public static void main(String[] args) {
		ApplicationContext context
			= new ClassPathXmlApplicationContext("annotation-component-scan.xml");
		TapeReader reader = context.getBean(TapeReader.class);
		reader.test();

	}
}

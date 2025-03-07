package dev.spring.java_config_with_scan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.spring.java_config_with_scan.domain.TapeReader;
import dev.spring.java_config_with_scan.config.ComponentScanConfig;

public class MyRoom {
	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(ComponentScanConfig.class).getBean(TapeReader.class).test();
	}
}

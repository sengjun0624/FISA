package dev.spring.java_config_with_scan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import dev.spring.config.domain.Tape;
import dev.spring.config.domain.TapeReader;

@ComponentScan(basePackages = "dev.spring.java_config_with_scan.domain")
public class ComponentScanConfig {

}

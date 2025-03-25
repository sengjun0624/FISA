package dev.security.step05_simple_api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// root(/)경로로 요청하면 index.html이 응답하도록 경로 매핑
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/product").setViewName("products");
	}
}

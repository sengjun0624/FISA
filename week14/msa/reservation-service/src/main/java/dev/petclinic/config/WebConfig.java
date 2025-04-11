package dev.petclinic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfig {
	private final String URL = "http://localhost:8081";
	@Bean
	public WebClient webClient(WebClient.Builder webClientBuilder){
		return webClientBuilder.baseUrl(URL).build();
	}
}

package com.example.EducationPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication @ComponentScan(basePackages = "com.example.EducationPortal")
@EnableJpaRepositories(basePackages = "com.example.EducationPortal.repositories")
@EntityScan(basePackages = "com.example.EducationPortal.models")
class Application implements WebMvcConfigurer { @Override
public void addCorsMappings(CorsRegistry registry) { registry.addMapping("/**");
}
	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}
	public static void main(String[] args) {
	SpringApplication.run(Application.class);
	}
}


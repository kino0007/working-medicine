package com.project;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan("com.project.*")
@EntityScan("com.project.entity")
@EnableJpaRepositories("com.project.repo")
@EnableScheduling
public class MedicineOrg2Application {

	
	@Scheduled(fixedDelay = 1800000)
	public void print() {
		System.out.println("Time = "+new Date());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MedicineOrg2Application.class, args);
	}
	
//	@Bean
//	public WebMvcConfigurer corsConfiguration() {
//		
//		return new WebMvcConfigurer() {
//			
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				// TODO Auto-generated method stub
//				
//				registry.addMapping("/**").allowedOrigins("http://127.0.0.1:8082");
//				
////				WebMvcConfigurer.super.addCorsMappings(registry);
//			}
//		};
//		
//	}

}

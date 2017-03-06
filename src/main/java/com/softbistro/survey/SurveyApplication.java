package com.softbistro.survey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.softbistro.survey")
public class SurveyApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SurveyApplication.class, args);
	}
}
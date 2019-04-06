package com.api.BankruptcyRiskAssessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
@EnableWebMvc
@EnableTransactionManagement
public class BankruptcyRiskAssessmentApplication extends WebMvcConfigurationSupport {

	public static void main(String[] args) {
		SpringApplication.run(BankruptcyRiskAssessmentApplication.class, args);
	}

}

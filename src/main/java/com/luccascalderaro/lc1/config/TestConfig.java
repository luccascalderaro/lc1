package com.luccascalderaro.lc1.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.luccascalderaro.lc1.service.DBService;
import com.luccascalderaro.lc1.service.EmailService;
import com.luccascalderaro.lc1.service.SmtpEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired DBService dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateDatabase();
		
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
	
	

}

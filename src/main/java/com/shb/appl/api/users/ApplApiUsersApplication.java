package com.shb.appl.api.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
	@EnableEurekaClient - to consider this service as a client to eureka server
 */
@EnableEurekaClient
@SpringBootApplication
public class ApplApiUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplApiUsersApplication.class, args);
	}

	//Make BcreptPasswordEncoder bean available in the application for use
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
}

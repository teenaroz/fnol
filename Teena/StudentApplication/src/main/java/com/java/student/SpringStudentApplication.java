package com.java.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableMongoRepositories("com.java.student.model")
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrix
public class SpringStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStudentApplication.class, args);
	}

}

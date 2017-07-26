package com.java.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableMongoRepositories("com.java.student.model")
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrix
public class SpringStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStudentApplication.class, args);
	}

}

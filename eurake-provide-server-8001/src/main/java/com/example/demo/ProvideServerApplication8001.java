package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author MyAcme
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker  //hystrix 回调注解
public class ProvideServerApplication8001 {
	public static void main(String[] args) {
		SpringApplication.run(ProvideServerApplication8001.class, args);
	}
}

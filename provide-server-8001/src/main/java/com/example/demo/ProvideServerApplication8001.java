package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MyAcme
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class ProvideServerApplication8001 {
	public static void main(String[] args) {
		SpringApplication.run(ProvideServerApplication8001.class, args);
	}

	@RequestMapping()
	public String production() {
		return "我是生产者！";
	}
}

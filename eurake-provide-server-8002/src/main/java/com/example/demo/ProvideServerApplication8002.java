package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author MyAcme
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class ProvideServerApplication8002 {
	public static void main(String[] args) {
		SpringApplication.run(ProvideServerApplication8002.class, args);
	}

	@Value("${server.port}")
	private String port;

	@RequestMapping()
	public String production() {
		return "我是Eurake生产者！" + port;
	}
}

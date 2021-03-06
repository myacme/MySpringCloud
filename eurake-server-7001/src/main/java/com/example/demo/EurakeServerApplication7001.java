package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * @author MyAcme
 */
@EnableEurekaServer
@SpringBootApplication
public class EurakeServerApplication7001 {
	public static void main(String[] args) {
		SpringApplication.run(EurakeServerApplication7001.class, args);
	}

}

package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/5/12 15:06
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication9527 {
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication9527.class, args);
	}
}
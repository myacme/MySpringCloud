package com.exmaple.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/5/19 16:17
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AlibabaConsumerServer80 {
	public static void main(String[] args) {
		SpringApplication.run(AlibabaConsumerServer80.class, args);
	}
}
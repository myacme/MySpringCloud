package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/5/19 15:48
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaProvideServer9001 {
	public static void main(String[] args) {
		SpringApplication.run(AlibabaProvideServer9001.class, args);
	}
}
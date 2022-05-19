package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/5/19 15:51
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaProvideServer9002 {
	public static void main(String[] args) {
		SpringApplication.run(AlibabaProvideServer9002.class, args);
	}

}
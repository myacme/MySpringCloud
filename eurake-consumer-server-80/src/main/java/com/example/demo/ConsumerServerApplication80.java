package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author MyAcme
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
//@RibbonClient(name = "provide-server",configuration = MyRule.class)  //ribbon 负载均衡
public class ConsumerServerApplication80 {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerServerApplication80.class, args);
	}
}

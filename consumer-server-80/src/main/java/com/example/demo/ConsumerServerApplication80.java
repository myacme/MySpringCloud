package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MyAcme
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class ConsumerServerApplication80 {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerServerApplication80.class, args);
	}

	@Autowired
	FeignService feignService;

	@GetMapping()
	public String sayHi() {
		return "消费者调用生产者："+feignService.getProduction();
	}

}

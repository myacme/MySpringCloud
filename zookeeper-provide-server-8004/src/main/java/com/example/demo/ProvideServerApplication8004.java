package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MyAcme
 */
@SpringBootApplication
@EnableDiscoveryClient  //consul 与 zookeeper 注册注解
public class ProvideServerApplication8004 {

	public static void main(String[] args) {
		SpringApplication.run(ProvideServerApplication8004.class, args);
	}

	@Value("${server.port}")
	private String port;

	@RequestMapping()
	public String production() {
		return "我是Zookeeper生产者！" + port;
	}

}

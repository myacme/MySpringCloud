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
@EnableDiscoveryClient
public class ConsulProvideServerApplication8005 {

	public static void main(String[] args) {
		SpringApplication.run(ConsulProvideServerApplication8005.class, args);
	}

	@Value("${server.port}")
	private String port;

	@RequestMapping()
	public String production() {
		return "我是Consul生产者！" + port;
	}

}

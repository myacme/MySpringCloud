package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MyAcme
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
public class ProvideServerApplication8001 {
	public static void main(String[] args) {
		SpringApplication.run(ProvideServerApplication8001.class, args);
	}

	@Value("${server.port}")
	private String port;

	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping()
	public String production() {
		return "我是Eurake生产者！" + port;
	}

	/**
	 * 服务发现
	 * @return
	 */
	@GetMapping("/msg")
	public List<String> discovery() {
		List<String> services = discoveryClient.getServices();
		List<String> list = new ArrayList<>(services.size());
		list.addAll(services);
		List<ServiceInstance> instances = discoveryClient.getInstances("provide-server");
		for (ServiceInstance instance : instances) {
			list.add(instance.getServiceId() + " " + instance.getHost() + " " + instance.getPort() + " " + instance.getUri());
		}
		return list;
	}
}

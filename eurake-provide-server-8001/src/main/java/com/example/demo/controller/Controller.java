package com.example.demo.controller;


import com.example.demo.service.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/5/11 14:41
 */
@RestController
@RefreshScope   //config 刷新注解
public class Controller {

	@Value("${server.port}")
	private String port;

	@Value("${config.name}")
	private String configName;

	@Resource
	private DiscoveryClient discoveryClient;

	@Resource
	private Service service;

	@GetMapping()
	public String production() {
		return "我是Eurake生产者！" + port;
	}

	@GetMapping("/hystrix/demotion")
	public String timeout() {
		return service.hystrixDemotion(port);
	}

	/**
	 * 服务发现
	 *
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

	@GetMapping("/config")
	public String setPort() {
		return configName;
	}
}
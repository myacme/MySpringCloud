package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/5/19 15:49
 */
@RestController
public class Controller {

	@Value("${server.port}")
	private String port;

	@Value("${config.name}")
	private String configName;

	@Resource
	private DiscoveryClient discoveryClient;


	@GetMapping()
	public String production() {
		return "我是Nacos生产者：" + port;
	}
}
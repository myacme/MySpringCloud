package com.example.demo.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/5/19 15:52
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


	@GetMapping("/hotKey")
	@SentinelResource(value = "hotKey", blockHandler = "hotKeyBlock", fallback = "fallBack")
	public String hotKey() {
		return "sentinel 热键限流测试 ";
	}

	public String hotKeyBlock() {
		return "限流规则异常方法";
	}

	public String fallBack() {
		return "Java异常方法";
	}
}
package com.example.demo.controller;


import com.example.demo.service.FeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/5/11 15:25
 */
@RestController
@DefaultProperties(defaultFallback = "hystrixDemotionFallbackGlobal")
public class Controller {

	@Resource
	FeignService feignService;

	@GetMapping()
	public String sayHi() {
		return "消费者调用生产者：" + feignService.getProduction();
	}

	/**
	 * hystrix 服务降级  单独配置服务降级
	 *
	 * @return
	 */
	@GetMapping("/hystrix/demotion")
	@HystrixCommand(fallbackMethod = "hystrixDemotionFallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")//3秒超时进入回调函数
	})
	public String hystrixDemotion() {
		return "消费者调用生产者：" + feignService.hystrixDemotion();
	}

	/**
	 * hystrix 服务降级  使用全局服务降级
	 *
	 * @return
	 */
	@GetMapping("hystrix/demotion/global")
	@HystrixCommand
	public String hystrixDemotionGlobal() {
		return "消费者调用生产者：" + feignService.hystrixDemotion();
	}

	public String hystrixDemotionFallback() {
		return "消费者调用生产者--失败  回调函数";
	}

	public String hystrixDemotionFallbackGlobal() {
		return "消费者调用生产者--失败  全局服务降级 回调函数";
	}
}
package com.example.demo.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/3/18 15:18
 */
@FeignClient(value = "provide-server", fallback = FeignserviceImpl.class)
public interface FeignService {

	@GetMapping()
	String getProduction();

	@GetMapping("/hystrix/demotion")
	String hystrixDemotion();
}
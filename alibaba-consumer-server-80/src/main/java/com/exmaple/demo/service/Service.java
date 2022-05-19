package com.exmaple.demo.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/5/19 16:19
 */
@FeignClient(value = "nacos-provider-server")
public interface Service {

	@GetMapping()
	String production();
}
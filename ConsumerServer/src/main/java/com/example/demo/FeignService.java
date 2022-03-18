package com.example.demo;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/3/18 15:18
 */
@FeignClient(value = "provide-service")
public interface FeignService {
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	String sayHiFromClientOne();
}
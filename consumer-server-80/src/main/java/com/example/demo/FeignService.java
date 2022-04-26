package com.example.demo;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/3/18 15:18
 */
@FeignClient(value = "provide-server-8001")
public interface FeignService {

	@GetMapping()
	String getProduction();
}
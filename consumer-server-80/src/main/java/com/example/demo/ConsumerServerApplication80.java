package com.example.demo;

import com.config.MyRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author MyAcme
 */
@SpringBootApplication
@EnableFeignClients
@RestController
//@RibbonClient(name = "provide-server",configuration = MyRule.class)  //ribbon 负载均衡
public class ConsumerServerApplication80 {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerServerApplication80.class, args);
	}

	@Autowired
	FeignService feignService;

	@GetMapping()
	public String sayHi() {
		return "消费者调用生产者："+feignService.getProduction();
	}

}

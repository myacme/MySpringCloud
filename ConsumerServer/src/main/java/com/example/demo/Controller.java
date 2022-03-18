package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/3/18 15:46
 */
@RestController
public class Controller {

	@Autowired
	FeignService feignService;

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String sayHi() {
		return feignService.sayHiFromClientOne();
	}
}
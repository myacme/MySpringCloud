package com.exmaple.demo.controller;


import com.exmaple.demo.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/5/19 16:20
 */
@RestController
public class Controller {

	@Resource
	Service service;

	@GetMapping()
	public String sayHi() {
		return "消费者调用生产者：" + service.production();
	}
}
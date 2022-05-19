package com.example.demo.controller;


import com.example.demo.service.MessageProvideService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/5/18 15:33
 */
@RestController
public class Controller {

	@Resource
	MessageProvideService messageProvideService;

	@GetMapping("/sendMessage")
	public String sendMessage() {
		return messageProvideService.sendMessage();
	}
}
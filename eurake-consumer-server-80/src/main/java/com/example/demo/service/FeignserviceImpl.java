package com.example.demo.service;


import org.springframework.stereotype.Component;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/5/11 15:43
 */
@Component
public class FeignserviceImpl implements FeignService {


	@Override
	public String getProduction() {
		return "消费者调用生产者 报错/超时/宕机  Feign 回调方法";
	}

	@Override
	public String hystrixDemotion() {
		return "消费者调用生产者 报错/超时/宕机  Feign 回调方法";
	}
}
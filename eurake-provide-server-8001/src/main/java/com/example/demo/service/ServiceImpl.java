package com.example.demo.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/5/11 14:38
 */
@Service
public class ServiceImpl implements com.example.demo.service.Service {
	//========服务降级

	/**
	 * 服务降级
	 *
	 * @param prot
	 * @return
	 */
	@Override
	@HystrixCommand(fallbackMethod = "hystrixDemotionFallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")//3秒超时进入回调函数
	})
	public String hystrixDemotion(String prot) {
		int i = 10 / 0;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "我是hystrix服务降级测试--超时接口，端口：" + prot;
	}

	/**
	 * 服务降级 回调方法
	 *
	 * @param prot
	 * @return
	 */
	public String hystrixDemotionFallback(String prot) {
		return "我是hystrix服务降级测试--超时/报错 回调函数，端口：" + prot;
	}
	//========服务熔断

	/**
	 * 服务熔断
	 *
	 * @param prot
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "hystrixCircuitFallback", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //是否开启断路器
			@HystrixProperty(name = "circuitBreaker.requestvolumeThreshold", value = "10"), // 请求次数
			@HystrixProperty(name = "circuitBreaker.sleepwindowInNilliseconds ", value = "10000"), // 时间窗口期
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //失败率达到多少后熔断
	})
	public String hystrixCircuit(String prot) {
		int i = 1 / 0;
		return "我是hystrix服务熔断测试--超时接口，端口：" + prot;
	}

	/**
	 * 服务熔断 回调方法
	 *
	 * @param prot
	 * @return
	 */
	public String hystrixCircuitFallback(String prot) {
		return "我是hystrix服务熔断测试--超时/报错 回调函数，端口：" + prot;
	}
}
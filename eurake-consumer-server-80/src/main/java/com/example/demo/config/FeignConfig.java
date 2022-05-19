package com.example.demo.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/5/9 15:24
 */
@Configuration
public class FeignConfig {

	@Bean
	public Logger.Level getFeignLoggerLevel() {
		return Logger.Level.FULL;
	}
}
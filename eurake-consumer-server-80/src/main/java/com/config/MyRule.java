package com.config;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/5/6 15:57
 */
@Configuration
public class MyRule {

	@Bean
	public IRule myRule() {
		return new RandomRule();
	}
}
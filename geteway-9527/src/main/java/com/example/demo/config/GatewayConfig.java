package com.example.demo.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;
import java.util.zip.ZipFile;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/5/12 15:37
 */
@Configuration
public class GatewayConfig {

	@Bean
	public RouteLocator myRouteLocator(RouteLocatorBuilder builder) {
		RouteLocatorBuilder.Builder routes = builder.routes();
		routes.route("baidu_route", r -> r.path("").uri("http://www.baidu.com")).build();
		return routes.build();
	}
}
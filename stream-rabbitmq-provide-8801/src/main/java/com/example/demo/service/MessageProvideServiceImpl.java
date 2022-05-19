package com.example.demo.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/5/18 15:27
 */
@EnableBinding(Source.class)
public class MessageProvideServiceImpl implements MessageProvideService {

	@Value("${server.port}")
	private String port;

	@Resource
	private MessageChannel output;

	@Override
	public String sendMessage() {
		String message = "消息生产者：" + port + "生产消息：" + UUID.randomUUID().toString();
		output.send(MessageBuilder.withPayload(message).build());
		System.out.println(message);
		return null;
	}
}
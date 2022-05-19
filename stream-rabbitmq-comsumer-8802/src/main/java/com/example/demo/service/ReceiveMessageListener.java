package com.example.demo.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/5/18 15:42
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListener {

	@Value("${server.port}")
	private String port;

	@StreamListener(Sink.INPUT)
	public void receiveMessage(Message<String> message) {
		System.out.println("消息消费者：" + port + " 接收消息：" + message.getPayload());
	}
}
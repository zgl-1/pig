/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.springrabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 朱桂林 create 2020/12/25 15:35
 */
@Component("topicConsumer")
public class Consumer {
	@RabbitListener(bindings = @QueueBinding(value = @Queue,
			exchange = @Exchange(value = "topic", type = "topic"),
			key ={"red.*.blue"}))
	public void consumer1(String message) {
		System.out.println("consumer1"+message);
	}

	@RabbitListener(bindings = @QueueBinding(value = @Queue,
			exchange = @Exchange(value = "topic", type = "topic"),
			key ={"red.#"}))
	public void consumer2(String message) {
		System.out.println("consumer2"+message);
	}

	@RabbitListener(bindings = @QueueBinding(value = @Queue,
			exchange = @Exchange(value = "topic", type = "topic"),
			key ={"#.blue"}))
	public void consumer3(String message) {
		System.out.println("consumer3"+message);
	}

	@RabbitListener(bindings = @QueueBinding(value = @Queue,
			exchange = @Exchange(value = "topic", type = "topic"),
			key ={"*.green.blue"}))
	public void consumer4(String message) {
		System.out.println("consumer4"+message);
	}
}

/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.springrabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 朱桂林 create 2020/12/25 15:05
 */
@Component("fanoutConsumer")
public class Consumer {
	@RabbitListener(bindings = {
			@QueueBinding(value = @Queue,
					exchange = @Exchange(value = "fanout", type = "fanout"))
	})
	public void consumer1(String message) {
		System.out.println("consumer1"+message);
	}

	@RabbitListener(bindings = {
			@QueueBinding(value = @Queue,
					exchange = @Exchange(value = "fanout", type = "fanout"))
	})
	public void consumer2(String message) {
		System.out.println("consumer2"+message);
	}
}

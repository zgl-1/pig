/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.springrabbitmq.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author 朱桂林 create 2020/12/25 14:50
 */
@Component("workConsumer")
public class Consumer {

	@RabbitListener(queuesToDeclare = @Queue("work"))
	public void consumer1(String message) throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(2);
		System.out.println("consumer1:"+message+"--"+System.currentTimeMillis());
	}

	@RabbitListener(queuesToDeclare = @Queue("work"))
	public void consumer2(String message){
		System.out.println("consumer2:"+message+"--"+System.currentTimeMillis());
	}
}

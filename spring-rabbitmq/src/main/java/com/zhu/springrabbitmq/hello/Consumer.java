package com.zhu.springrabbitmq.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*
 *xiaozhu
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello",declare = "true"))
public class Consumer {


    @RabbitHandler
    public void getMessage(String message){
        System.out.println(message);
    }
}

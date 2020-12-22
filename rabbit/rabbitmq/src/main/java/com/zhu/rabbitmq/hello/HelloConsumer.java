package com.zhu.rabbitmq.hello;

import com.rabbitmq.client.*;
import com.zhu.rabbitmq.RabbitMQUtils;

import java.io.IOException;

/*
 *xiaozhu
 */
public class HelloConsumer {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        //获取通道
        Channel channel = connection.createChannel();
        channel.queueDeclare("hello",false,false,false,null);

        //参数1:队列名称
        //参数2:是否消息确认
        //参数3:消费回调
        channel.basicConsume("hello",true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消息内容为:"+new String(body));
            }
        });
    }
}

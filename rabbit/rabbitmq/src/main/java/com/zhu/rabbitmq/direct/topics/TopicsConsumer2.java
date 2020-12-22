package com.zhu.rabbitmq.direct.topics;

import com.rabbitmq.client.*;
import com.zhu.rabbitmq.RabbitMQUtils;

import java.io.IOException;

/*
 *xiaozhu
 */
public class TopicsConsumer2 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("topics","topic");

        String queue = channel.queueDeclare().getQueue();
        channel.queueBind(queue,"topics","*.blue.*");
        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费blue为中间的，不关心前后内容，消息内容为："+new String(body) );
            }
        });
    }
}

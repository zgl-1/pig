package com.zhu.rabbitmq.direct.routing;

import com.rabbitmq.client.*;
import com.zhu.rabbitmq.RabbitMQUtils;

import java.io.IOException;

/*
 *xiaozhu
 */
public class RoutingConsumer1 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("direct","direct");

        String queue = channel.queueDeclare().getQueue();

        channel.queueBind(queue,"direct","red");

        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("这里只接受red，消息内容为："+new String(body));
            }
        });
    }
}

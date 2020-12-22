package com.zhu.rabbitmq.direct.topics;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zhu.rabbitmq.RabbitMQUtils;

import java.io.IOException;

/*
 *xiaozhu
 */
public class TopicsProvider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("topics","topic");
        channel.basicPublish("topics","green.blue.green",null,"topics消息模型".getBytes());
        RabbitMQUtils.close(channel,connection);
    }
}

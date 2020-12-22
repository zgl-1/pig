package com.zhu.rabbitmq.direct.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zhu.rabbitmq.RabbitMQUtils;

import java.io.IOException;

/*
 *xiaozhu
 */
public class RoutingProvider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("direct","direct");
        channel.basicPublish("direct","blue",null,"direct消息模型".getBytes());
        RabbitMQUtils.close(channel,connection);
    }
}

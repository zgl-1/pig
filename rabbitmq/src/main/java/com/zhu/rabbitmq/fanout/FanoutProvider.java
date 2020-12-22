package com.zhu.rabbitmq.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zhu.rabbitmq.RabbitMQUtils;

import java.io.IOException;

/*
 *xiaozhu
 */
public class FanoutProvider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();

        //获取通道
        Channel channel = connection.createChannel();

        //申明交换机
        //参数1：交换机名称
        //参数2：交换机类型
        channel.exchangeDeclare("fanout","fanout");

        //发送消息
        //参数1：交换机名称
        //参数2：路由key
        //参数3：消息持久化
        //参数4：消息内容
        channel.basicPublish("fanout","",null,"这是fanout类型".getBytes());

        RabbitMQUtils.close(channel,connection);
    }
}

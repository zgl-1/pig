package com.zhu.rabbitmq.hello;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zhu.rabbitmq.RabbitMQUtils;

import java.io.IOException;

/*
 *xiaozhu
 */
public class HelloProvider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();

        //获取通道
        Channel channel = connection.createChannel();

        //通道绑定队列
        //参数1：队列名称，不存在会自动创建
        //参数2：队列是否持久化
        //参数3：是否独占队列（是否允许其他连接可用） true独占 false不独占
        //参数4：是否在消息消费完后自动删除
        //参数5：附加参数
        channel.queueDeclare("hello", false, false, false, null);

        //发布消息
        //参数1：交换机名称
        //参数2：队列名称
        //参数3：额外设置
        //参数4：消息内容，必须为字节数组
        channel.basicPublish("", "hello", null, "这是hello".getBytes());

        RabbitMQUtils.close(channel,connection);
    }
}

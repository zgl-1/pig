package com.zhu.rabbitmq.work;

import com.rabbitmq.client.*;
import com.zhu.rabbitmq.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/*
 *xiaozhu
 */
public class WorkConsumer1 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        //获取通道
        Channel channel = connection.createChannel();

        //每次消费多少个消息
        channel.basicQos(1);

        channel.queueDeclare("work",false,false,false,null);

        //参数1:队列名称
        //参数2:是否自动消息确认
        //参数3:消费回调
        channel.basicConsume("work",false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("work模型消费者1:"+new String(body));

                //手动确认
                //确认标识
                //是否开启多个消息自动确认
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
    }
}

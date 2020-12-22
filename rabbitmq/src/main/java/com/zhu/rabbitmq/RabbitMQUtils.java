package com.zhu.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/*
 *xiaozhu
 */
public class RabbitMQUtils {
    private static ConnectionFactory factory;

    static {
        //创建工厂
        factory = new ConnectionFactory();
        //设置主机
        factory.setHost("192.168.137.100");
        //设置端口号
        factory.setPort(5672);
        //设置连接的主机
        factory.setVirtualHost("/mes");
        //设置用户
        factory.setUsername("guest");
        //设置密码
        factory.setPassword("guest");


    }

    public static Connection getConnection() {

        try {
            //获取连接
            Connection connection = factory.newConnection();
            return connection;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Channel channel, Connection connection) {
        try {
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}

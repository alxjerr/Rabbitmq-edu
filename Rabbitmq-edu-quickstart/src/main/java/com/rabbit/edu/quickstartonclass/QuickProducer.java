package com.rabbit.edu.quickstartonclass;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class QuickProducer {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("123.206.13.202");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/behavior");      // 设置虚拟主机
        connectionFactory.setPassword("guest");
        connectionFactory.setUsername("guest");
        connectionFactory.setConnectionTimeout(100000);

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        for (int i = 0; i < 5; i++) {
            String message = "hello--" + i;
            channel.basicPublish("","tuling-queue-01",null,message.getBytes());
        }
        channel.close();
        connection.close();
    }


}

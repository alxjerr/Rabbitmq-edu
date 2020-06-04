package com.rabbit.edu.quickstartonclass;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.net.ConnectException;
import java.util.concurrent.TimeoutException;

public class QuickConsumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("123.206.13.202");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/behavior");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setConnectionTimeout(100000);

        Connection connection  = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

    }


}

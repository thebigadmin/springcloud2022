package com.bjpowernode.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class CustomerController {

    @Value("${server.port}")
    private String port;

    @StreamListener(target=Sink.INPUT)
    public void input(Message<String> message){
        String payload = message.getPayload();
        System.out.println("消费者1号---->"+payload+"port---->"+port);
    }

}

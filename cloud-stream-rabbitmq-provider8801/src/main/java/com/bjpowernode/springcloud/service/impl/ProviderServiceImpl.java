package com.bjpowernode.springcloud.service.impl;


import com.bjpowernode.springcloud.service.ProviderService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)
public class ProviderServiceImpl implements ProviderService {

    // 注入消息管道
    @Resource
    private MessageChannel output;

    @Override
    public String send() {

        String result = UUID.randomUUID().toString();
        // 创建并发送消息
        output.send(MessageBuilder.withPayload(result).build());
        System.out.println("=========="+result);
        return result;
    }
}

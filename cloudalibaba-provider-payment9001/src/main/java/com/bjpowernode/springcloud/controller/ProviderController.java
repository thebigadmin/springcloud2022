package com.bjpowernode.springcloud.controller;

import com.bjpowernode.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class ProviderController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/get/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        log.info("服务端口--->{}*****id---->{}",port,id);
        return "服务端口--->"+port+"*****id---->"+id;
    }

    @GetMapping("/get")
    public Payment get(){
        return new Payment(123, UUID.randomUUID().toString());
    }

}

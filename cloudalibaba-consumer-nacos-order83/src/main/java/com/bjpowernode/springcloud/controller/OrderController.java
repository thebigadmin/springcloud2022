package com.bjpowernode.springcloud.controller;

import com.bjpowernode.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Value("${service-url.nacos-user-service}")
    private String path;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/customer/payment/get/{id}")
    public String order(@PathVariable("id") Integer id){

        return restTemplate.getForObject(path+"/payment/get/"+id,String.class);
    }
    @GetMapping("/customer/payment")
    public Object order1(){
        ResponseEntity<Payment> paymentResponseEntity = restTemplate.getForEntity(path+"/get",Payment.class);
        return paymentResponseEntity;
    }

}

package com.bjpowernode.springcloud.controller;

import com.bjpowernode.springcloud.entities.CommonResult;
import com.bjpowernode.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderController {

    /*public static final String URL = "http://localhost:8001";*/
    public static final String URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/customer/create")
    public CommonResult createPayment(Payment payment){
        log.info("参数为{}{}",payment.getId(),payment.getSerial());
        return restTemplate.postForObject(URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/customer/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable long id){
        return restTemplate.getForObject(URL+"/payment/get/"+id,CommonResult.class,id);
    }

}

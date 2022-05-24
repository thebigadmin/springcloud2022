package com.bjpowernode.springcloud.controller;

import com.bjpowernode.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/get/{id}")
    public String getOk(@PathVariable("id") Integer id){
        return paymentService.getOk(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String getTimeOut(@PathVariable("id") Integer id){
        return paymentService.getTimeOut(id);
    }
}

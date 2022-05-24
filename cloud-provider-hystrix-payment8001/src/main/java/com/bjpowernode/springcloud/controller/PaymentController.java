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

    @GetMapping("/payment/get/ok/{id}")
    public String getOk(@PathVariable("id") Integer id){
        return paymentService.payment_Ok(id);
    }

    @GetMapping("/payment/get/timeout/{id}")
    public String getTimeOut(@PathVariable("id") Integer id){
        return paymentService.payment_TimeOut(id);
    }

    @GetMapping("/payment/get/{num}")
    public String getNum(@PathVariable("num") Integer num){
        return paymentService.testCircuit(num);
    }
}

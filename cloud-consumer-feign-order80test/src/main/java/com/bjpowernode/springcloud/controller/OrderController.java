package com.bjpowernode.springcloud.controller;

import com.bjpowernode.springcloud.entities.CommonResult;
import com.bjpowernode.springcloud.entities.Payment;
import com.bjpowernode.springcloud.service.PaymentServiceOfFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private PaymentServiceOfFeign paymentServiceOfFeign;

    @GetMapping("/customer/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") long id){
        return paymentServiceOfFeign.getPayment(id);
    }

}

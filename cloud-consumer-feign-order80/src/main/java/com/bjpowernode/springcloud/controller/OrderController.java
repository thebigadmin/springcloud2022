package com.bjpowernode.springcloud.controller;

import com.bjpowernode.springcloud.entities.CommonResult;
import com.bjpowernode.springcloud.entities.Payment;
import com.bjpowernode.springcloud.openfeign.MyFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private MyFeign myFeign;

    @GetMapping("/customer/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") long id){
        CommonResult<Payment> payment = myFeign.getPayment(id);
        return payment;
    }

}

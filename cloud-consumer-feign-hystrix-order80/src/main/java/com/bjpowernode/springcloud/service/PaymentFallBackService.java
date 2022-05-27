package com.bjpowernode.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallBackService implements PaymentService{
    @Override
    public String getOk(Integer id) {
        return "null";
    }

    @Override
    public String getTimeOut(Integer id) {
        return "null";
    }

    @Override
    public String getZip() {
        return null;
    }
}

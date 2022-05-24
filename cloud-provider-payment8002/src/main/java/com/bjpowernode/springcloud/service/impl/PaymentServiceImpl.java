package com.bjpowernode.springcloud.service.impl;

import com.bjpowernode.springcloud.entities.Payment;
import com.bjpowernode.springcloud.mapper.PaymentMapper;
import com.bjpowernode.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int createPayment(Payment payment) {
        return paymentMapper.createPayment(payment);
    }

    @Override
    public Payment getPaymentById(long id) {
        return paymentMapper.getPaymentById(id);
    }
}

package com.bjpowernode.springcloud.mapper;

import com.bjpowernode.springcloud.entities.Payment;


public interface PaymentMapper {

    int createPayment(Payment payment);

    Payment getPaymentById(long id);
}

package com.bjpowernode.springcloud.service;

import com.bjpowernode.springcloud.entities.Payment;

public interface PaymentService {

    int createPayment(Payment payment);

    Payment getPaymentById(long id);
}

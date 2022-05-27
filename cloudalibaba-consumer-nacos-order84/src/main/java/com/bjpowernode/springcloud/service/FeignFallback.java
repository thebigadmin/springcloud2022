package com.bjpowernode.springcloud.service;

import com.bjpowernode.springcloud.entities.CommonResult;
import com.bjpowernode.springcloud.entities.Payment;


public class FeignFallback {

    public static CommonResult<Payment> paymentSQL1(Long id,Throwable throwable) {
        return new CommonResult<>(404,"------------------------fallback方法触发");
    }
}

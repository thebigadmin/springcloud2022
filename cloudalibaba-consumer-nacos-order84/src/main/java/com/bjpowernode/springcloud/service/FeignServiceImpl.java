package com.bjpowernode.springcloud.service;

import com.bjpowernode.springcloud.entities.CommonResult;
import com.bjpowernode.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceImpl implements FeignService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(404,"---------feign---------------fallback方法触发");
    }
}

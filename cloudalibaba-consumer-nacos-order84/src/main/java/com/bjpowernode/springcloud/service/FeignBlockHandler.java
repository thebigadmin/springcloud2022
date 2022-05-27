package com.bjpowernode.springcloud.service;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bjpowernode.springcloud.entities.CommonResult;
import com.bjpowernode.springcloud.entities.Payment;


public class FeignBlockHandler{

    public static CommonResult<Payment> paymentSQL2(Long id, BlockException blockException) {
        return new CommonResult<>(404,"------------------blockHandler方法触发");
    }
}

package com.bjpowernode.springcloud.service;

import com.bjpowernode.springcloud.entities.CommonResult;
import com.bjpowernode.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = FeignServiceImpl.class)
public interface FeignService {

    @GetMapping(value = "/paymentSQL/{id}")
    //@SentinelResource(value = "fallback",
            //blockHandlerClass = FeignBlockHandler.class,blockHandler = "paymentSQL",
            //fallbackClass = FeignFallback.class,fallback = "paymentSQL")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}

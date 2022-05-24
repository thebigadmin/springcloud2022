package com.bjpowernode.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String payment_Ok(Integer id){
        return Thread.currentThread().getName()+"payment_Ok--->id="+id;
    }

    @HystrixCommand(fallbackMethod = "HystrixCommand_TimeOut",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String payment_TimeOut(Integer id){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName()+"payment_TimeOut--->id="+id;
    }

    public String HystrixCommand_TimeOut(Integer id){
        return "调用时间超时"+Thread.currentThread().getName()+"payment_TimeOut--->id="+id;
    }

    @HystrixCommand(fallbackMethod = "fallbackTest",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
    })
    public String testCircuit(Integer num){
        if (num < 0){
            throw new RuntimeException("========不能为负数");
        }
        String simpleUUID = IdUtil.simpleUUID();
        return "成功！流水号为:"+simpleUUID;
    }
    public String fallbackTest(Integer num){
        return "失败，不能为负数";
    }
}

package com.bjpowernode.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallBackService.class)

public interface PaymentService {

    @GetMapping("/payment/get/ok/{id}")
     String getOk(@PathVariable("id") Integer id);

    @GetMapping("/payment/get/timeout/{id}")
     String getTimeOut(@PathVariable("id") Integer id);
}

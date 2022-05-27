package com.bjpowernode.springcloud.openfeign;

import com.bjpowernode.springcloud.entities.CommonResult;
import com.bjpowernode.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface MyFeign {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPayment( @PathVariable("id") long id);

    @GetMapping("/get/zip")
    public String getZip();
}

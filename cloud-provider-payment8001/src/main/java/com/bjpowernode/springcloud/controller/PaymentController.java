package com.bjpowernode.springcloud.controller;

import com.bjpowernode.springcloud.entities.CommonResult;
import com.bjpowernode.springcloud.entities.Payment;
import com.bjpowernode.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private Integer serverPort;

    @PostMapping("/payment/create")
    public CommonResult createPayment(@RequestBody Payment payment){
        long id = payment.getId();
        int result = paymentService.createPayment(payment);
        log.info("===========插入返回结果为："+result);
        if (result > 0){
            return new CommonResult(200,"添加成功端口"+serverPort,null);
        }else {
            return new CommonResult(404,"添加失败端口"+serverPort,null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable long id){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Payment payment = paymentService.getPaymentById(id);
        log.info("============查询结果为：{}",payment);
        if (payment != null){
            return new CommonResult(200,"查询成功端口"+serverPort,payment);
        }else {
            return new CommonResult(404,"查询失败端口"+serverPort,null);
        }
    }

    @GetMapping("/payment/get/lb")
    public String getLB(){
        return serverPort.toString();
    }
}

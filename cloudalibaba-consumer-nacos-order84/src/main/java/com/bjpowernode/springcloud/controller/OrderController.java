package com.bjpowernode.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.bjpowernode.springcloud.entities.CommonResult;
import com.bjpowernode.springcloud.entities.Payment;
import com.bjpowernode.springcloud.service.FeignBlockHandler;
import com.bjpowernode.springcloud.service.FeignFallback;
import com.bjpowernode.springcloud.service.FeignService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    public static final String URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private FeignService feignService;

    @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",
                        blockHandlerClass = FeignBlockHandler.class,
            blockHandler = "paymentSQL2",
                        fallbackClass = FeignFallback.class,
            fallback = "paymentSQL1")
    public CommonResult<Payment> fallback(@PathVariable Long id)
    {
        //CommonResult<Payment> result = restTemplate.getForObject(URL + "/paymentSQL/"+id, CommonResult.class,id);

        CommonResult<Payment> result = feignService.paymentSQL(id);
        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }


}

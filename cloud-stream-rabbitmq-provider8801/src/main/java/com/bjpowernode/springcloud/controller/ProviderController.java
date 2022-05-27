package com.bjpowernode.springcloud.controller;

import com.bjpowernode.springcloud.service.ProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProviderController {

    @Resource
    private ProviderService providerService;

    @GetMapping("/send")
    public String send(){
        return providerService.send();
    }

}

package com.bjpowernode.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope
public class ConfigController {

    @Value("${config.info}")
    private String info;


    @GetMapping("/config/getinfo")
    public String getInfo(){
        log.info("getInfo---->{}",info);
        return info;
    }
}

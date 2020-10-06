package com.springclould.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class HelloNacosController {
    @Value("${nacos.test}")
    private String nacosTest;

    @RequestMapping("/hello")
    public String hello(@RequestBody Map map){
        System.out.println(nacosTest+":"+map);
        return "hello nacos";
    }
}

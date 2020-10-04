package com.springclound.client.controller;

import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springclound.client.service.FeignTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FeignTestController {
    @Autowired
    private FeignTestService feignTestService;

    //这里测试非feign的熔断
    @RequestMapping("/feignHello")
    @HystrixCommand(fallbackMethod = "fail")
    public String test(){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("ab","aa");
        return feignTestService.hello(paramMap);
    }

    //熔断方法必须与test方法参数一致，多的Throwable可以打印异常信息
    private String fail(Throwable throwable) {

        //备用逻辑
        return "controller fail";
    }

}

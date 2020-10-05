package com.springclould.server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController
{

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello")
    public String test(@RequestBody Map map){
        System.out.println(map);
        //int i = 1/0;
        return "helo world:"+port;
    }

}

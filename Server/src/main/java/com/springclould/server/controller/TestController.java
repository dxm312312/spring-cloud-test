package com.springclould.server.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController
{

    @RequestMapping("/hello")
    public String test(@RequestBody Map map){
        System.out.println(map);
        return "helo world";
    }

}

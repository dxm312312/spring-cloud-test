package com.springclould.nacosconsumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class TestController {

    private final RestTemplate restTemplate;

    @Autowired
    public TestController(RestTemplate restTemplate) {this.restTemplate = restTemplate;}

    @RequestMapping(value = "/hello")
    @SentinelResource(value = "sayHello", blockHandler = "exceptionHandler", fallback = "helloFallback")
    public String hello(@RequestBody Map map) {
        return restTemplate.postForObject("http://nacos-provider/hello", map, String.class);
    }

    //这个是抛异常执行的方法
    public String helloFallback(Map map,Throwable t) {
        return String.format("exception"+t.getMessage());
    }

    // 限流抛的Block 异常 执行这个方法
    public String exceptionHandler(Map map, BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "限流啦"+map.toString();
    }
}

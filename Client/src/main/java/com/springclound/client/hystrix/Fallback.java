package com.springclound.client.hystrix;

import com.springclound.client.service.FeignTestService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Fallback implements FeignTestService {
    @Override
    public String hello(Map map) {
        return "feign fail";
    }
}

package com.springclound.client.service;

import com.springclound.client.hystrix.Fallback;
import com.springclound.client.hystrix.FeignFallbackFactory;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
//feign 熔断默认不开启  需要设置为true  feign.hystrix.enabled=true
//@FeignClient(name = "s1",fallback = Fallback.class)
@FeignClient(name = "s1",fallbackFactory = FeignFallbackFactory.class)
public interface FeignTestService {

    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public String hello(@RequestBody Map map);
}

package com.springclound.client.hystrix;

import com.springclound.client.service.FeignTestService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FeignFallbackFactory implements FallbackFactory<FeignTestService> {

    @Override
    public FeignTestService create(Throwable throwable) {
        System.out.println("异常信息:"+throwable);
        return new FeignTestService() {
            @Override
            public String hello(Map map) {
                return "feign exception info fall back";
            }
        };
    }
}

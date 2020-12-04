package com.springclould.nacosconsumer.origin;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LimitAppRequestOriginParser implements RequestOriginParser{

    //设置不同来源，可以根据来源设置规则
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String origin = httpServletRequest.getHeader("limitapp");
        return origin!=null?origin:"other";
    }
}

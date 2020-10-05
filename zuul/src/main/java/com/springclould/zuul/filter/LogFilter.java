package com.springclould.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sun.deploy.net.HttpUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

//自定义拦截器
@Component
public class LogFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //PRE: 在请求被路由之前调用，可利用这种过滤器实现身份验证。选择微服务，记录日志。
        //ROUTING:在将请求路由到微服务调用，用于构建发送给微服务的请求，并用http clinet（或者ribbon）请求微服务。
        //POST:在调用微服务执行后。可用于添加header，记录日志，将响应发给客户端。
        //ERROR:在其他阶段发生错误是，走此过滤器。
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //执行顺序  数字小先执行
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //此过滤器是否执行
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String method = request.getMethod();//请求的类型，post get ..
        String paramsStr = request.getParameter("id");//请求的参数
        System.out.println(paramsStr);
        Throwable throwable = context.getThrowable();//请求的异常，如果有的话
        System.out.println(request.getRequestURI());
        System.out.println(context.getResponseStatusCode());

        return null;
    }
}

package com.springclound.client;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

//@EnableFeignClients 开启feign
//EnableCircuitBreaker 熔断  与 EnableHystrix功能相同
@SpringBootApplication
@EnableFeignClients
//@EnableCircuitBreaker
@EnableHystrix
//断路器监控可视化   http://localhost:8101/hystrix   http://localhost:8101/actuator/hystrix.stream
@EnableHystrixDashboard
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	//要想  Dashboard 监控，这个bean也是要的，具体原因还不知道，以后再看
	//是因为Srping Boot 2.0以后仪表盘的默认路径不在是 /hystrix.stream，这时就需要我们自己去设置，在主类中添加以下代码
	@Bean
	public ServletRegistrationBean hystrixMetricsStreamServlet(){
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
		registrationBean.addUrlMappings("/actuator/hystrix.stream");
		return registrationBean;
	}
}

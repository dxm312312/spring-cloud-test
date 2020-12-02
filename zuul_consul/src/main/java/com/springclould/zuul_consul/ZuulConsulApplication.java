package com.springclould.zuul_consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableZuulProxy
public class ZuulConsulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulConsulApplication.class, args);
	}



}

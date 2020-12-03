package com.springclould.nacosconsumer;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosconsumerApplication {

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(NacosconsumerApplication.class, args);
	}


}

@RestController
 class TestController {

	private final RestTemplate restTemplate;

	@Autowired
	public TestController(RestTemplate restTemplate) {this.restTemplate = restTemplate;}

	@RequestMapping(value = "/hello")
	@SentinelResource(value = "sayHello")
	public String hello(@RequestBody Map map) {
		return restTemplate.postForObject("http://nacos-provider/hello", map, String.class);
	}
}

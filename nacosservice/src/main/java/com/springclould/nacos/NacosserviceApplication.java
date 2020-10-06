package com.springclould.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosserviceApplication.class, args);
	}

}

package com.charles.ribbonconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * EnableCircuitBreaker注解添加断路器功能
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
public class RibbonConsumerApplication {

	/**
	 * 创建restTemplate的Spring bean实例
	 * 并通过@LoadBalanced注解开启客户端负载均衡
	 * @return
	 */
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(RibbonConsumerApplication.class, args);
	}
}

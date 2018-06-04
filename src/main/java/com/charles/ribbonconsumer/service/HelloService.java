package com.charles.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IDEA
 * Description: 测试断路器功能
 * User: Charles
 * Date: 2018-06-03 22:18
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService(){
        return restTemplate.getForEntity("http://HELLO-CHARLES/hello",String.class).getBody();
    }

    public String helloFallback(){
        return "error";
    }
}

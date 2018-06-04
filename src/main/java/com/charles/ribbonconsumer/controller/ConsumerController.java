package com.charles.ribbonconsumer.controller;

import com.charles.ribbonconsumer.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IDEA
 * Description: 服务消费controller
 * User: Charles
 * Date: 2018-05-18 22:53
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/ribbon-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        /**
         * getForEntity()方法第二个参数表示body的对象类型
         * 该方法有三种不同的方法重载实现
         */
        //return restTemplate.getForEntity("http://HELLO-CHARLES/hello",String.class).getBody();

        return helloService.helloService();
    }
}

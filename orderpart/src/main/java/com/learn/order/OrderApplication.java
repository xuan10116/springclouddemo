package com.learn.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EntityScan("com.learn.order.entity")
@EnableFeignClients //激活FeignClient
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }

    /*
    * 使用spring提供的RestTemplate发送http请求到prodctpart的服务
    *   1，容器中创建RestTemplate对象
    *   2，在使用的时候，调用RestTemplate对象的方法
    *   (3，借助 Ribbon ，帮助我们负载均衡、自动选择对应名称的微服务；做法：
    *       第一步，使用“@LoadBalanced”注解标注RestTemplate
    *       第二步，使用“服务名”替换自己拼接的ip地址
    *   )
    * */
/*
    //现在使用feign，不需要再通过restTemplate和Ribbon来发请求和负载均衡了，两种的负载均衡配置是一样的，无需修改
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }*/
}

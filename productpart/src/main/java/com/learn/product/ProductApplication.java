package com.learn.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan("com.learn.product.entity")
//激活Eureka Client，使用下面两个注解都是一样的，最新版的springcloud只要配置了注册中心即使不enable也是可以的
//@EnableEurekaClient //netflix提供
//@EnableDiscoveryClient //springcloud提供
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class,args);
    }
}

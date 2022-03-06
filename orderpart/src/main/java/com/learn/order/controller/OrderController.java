package com.learn.order.controller;

import com.learn.order.command.OrderCommand;
import com.learn.order.entity.Product;
import com.learn.order.feign.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 通过order系统，调用product系统的服务根据id查询商品信息
 *   1，需要配置与product中对应的商品对象
 *   2，需要“通过某种方法”调用product中的服务
 *       方法：urlconnection，httpclient，okhttp等
 *       我们采取“RestTemplate”，发送http请求
 *
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    //使用OrderCommand调用远程服务
    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id){
        return new OrderCommand(restTemplate,id).execute();
    }

    //单纯的模拟一个非使用远程调用的一个方法
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String unableFunction(@PathVariable Long id){
        return "No."+id+",product";
    }

}

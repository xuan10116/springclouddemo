package com.learn.order.controller;

import com.learn.order.entity.Product;
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
    /*
    * 注入 DiscoveryClient【注意使用springcloud包下的】：
    *   spring cloud提供的获取原数组的工具类
    *       调用方法获取服务的元数据信息
    * */
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;
    //2，Eureka借助Ribbon，通过“服务名”自动选择注册中心对应的微服务
    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id){
        Product product = null;
        product = restTemplate.getForObject("http://service-product/"+"product/"+id,Product.class);
        return product;
    }

/*
    //1，单纯的使用Eureka，手动选择对应的微服务拼接ip
    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id){
        //调用discoveryClient方法
        //通过调用服务名称获取所有元数据
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        //此时，演示案例中我们只向eureka server中注册了一个product服务
        ServiceInstance instance = instances.get(0);
        //拿到元数据的主机地址和端口号，拼接请求微服务的URL
        return restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/product/"+id,Product.class);

        //手动拼接服务的url
        //return restTemplate.getForObject("http://127.0.0.1:9001/product/"+id,Product.class);
    }
*/
}

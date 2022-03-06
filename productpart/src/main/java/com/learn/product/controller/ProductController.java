package com.learn.product.controller;

import com.learn.product.entity.Product;
import com.learn.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //为了体现ribbon的负载均衡将请求打到不同的微服务上，这里做一些标识
    @Value("${server.port}")
    private String curPort;
    @Value("${spring.cloud.client.ip-address}") //spring cloud 会自动的获取当前应用的ip地址
    private String curIp;


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) {
        //模拟时间较长的操作
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Product product = productService.findById(id);
        product.setProductName("当前微服务地址："+curIp+":"+curPort);
        return product;
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String save(@RequestBody Product product) {
        productService.save(product);
        return "save success";
    }
}

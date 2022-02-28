package com.learn.product.controller;

import com.learn.product.entity.Product;
import com.learn.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String save(@RequestBody Product product) {
        productService.save(product);
        return "save success";
    }
}

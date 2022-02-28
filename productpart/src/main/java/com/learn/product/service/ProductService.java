package com.learn.product.service;

import com.learn.product.entity.Product;
import org.springframework.stereotype.Service;

public interface ProductService {

    Product findById(Long id);

    void save(Product product);

    void update(Product product);

    void delete(Long id);
}

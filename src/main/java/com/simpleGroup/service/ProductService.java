package com.simpleGroup.service;

import com.simpleGroup.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(long id);

    void deleteById(long id);

    void saveOrUpdate(Product product);
}

package com.javawiz.service;

import java.util.List;

import com.javawiz.entity.Product;

public interface ProductService {
    List<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}
package com.troc.service;

import com.troc.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();

    Product findProduct(Long id);

    Product saveProduct(Product product);

    void deleteProductById(Long id);


}

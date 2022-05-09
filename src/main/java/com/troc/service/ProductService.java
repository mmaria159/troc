package com.troc.service;

import com.troc.dto.ProductDTO;
import com.troc.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAllProducts();

    ProductDTO findProduct(Long id);

    Product saveProduct(Product product);

    void deleteProductById(Long id);
}

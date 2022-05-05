package com.troc.service;

import com.troc.dto.ProductDTO;
import com.troc.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<ProductDTO> findAllProducts();

    Product findProduct(Long id);

    Product saveProduct(Product product) throws IOException;

    void deleteProductById(Long id);


}

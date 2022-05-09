package com.troc.service;

import com.troc.dto.ProductDTO;
import com.troc.entity.ECategory;
import com.troc.entity.ERegion;
import com.troc.entity.Product;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAllProducts();

    List<ProductDTO> findAllProducts(String orderBy, Sort.Direction direction);

    ProductDTO findProduct(Long id);

    Product saveProduct(Product product);

    void deleteProductById(Long id);

    List<Product> findProductsByCategoryName(ECategory categoryName);
  
    List<Product> findProductsByRegionName(ERegion region);
  
    List<Product> findNewestProducts(Product id);
}

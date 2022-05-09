package com.troc.service.impl;

import com.troc.dto.ProductDTO;
import com.troc.entity.*;
import com.troc.exceptions.ProductNotFoundException;
import com.troc.exceptions.UserNotFoundException;
import com.troc.mapper.ProductMapper;
import com.troc.repository.ProductRepository;
import com.troc.service.ProductService;
import org.springframework.data.domain.Sort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    public List<ProductDTO> findAllProducts() {
        return productMapper.productToProductDTO(productRepository.findAll());
    }

    @Override
    public List<ProductDTO> findAllProducts(String orderBy, Sort.Direction direction) {
        return productMapper
                .productToProductDTO(productRepository
                        .findAllSortingProducts(Sort.by(direction, orderBy))
                        .orElseThrow(()-> new ProductNotFoundException("ERROR")));
    }

    @Override
    public ProductDTO findProduct(Long id) {
        return productMapper.productToProductDTO(productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found by id: " + id)));
    }

    @Override
    public Product saveProduct(Product product) {

        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findProductsByCategoryName(ECategory category) {
        List<Product> products = productRepository.findProductsByCategory(category)
                .orElseThrow(() -> new ProductNotFoundException("Product not found by category name:" + category));
        return products;
    }

    @Override
    public List<Product> findProductsByRegionName(ERegion region) {
        List<Product> products = productRepository.findProductsByRegion(region)
                .orElseThrow(() -> new ProductNotFoundException("Product not found by region name:" + region));
        return products;
    }

    @Override
    public List<Product> findNewestProducts(Product id) {
        List<Product> products = productRepository.findNewestProducts(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found by region name:" + id));
        return products;
    }
}

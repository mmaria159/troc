package com.troc.service.impl;

import com.troc.dto.ProductDTO;
import com.troc.entity.Product;
import com.troc.exceptions.ProductNotFoundException;
import com.troc.mapper.ProductMapper;
import com.troc.repository.ProductRepository;
import com.troc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public List<ProductDTO> findAllProducts() {
        return productMapper.productToProductDTO(productRepository.findAll());
    }

    @Override
    @Transactional
    public ProductDTO findProduct(Long id) {
        return productMapper.productToProductDTO(productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found by id: " + id)));
    }

    @Override
    @Transactional
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}

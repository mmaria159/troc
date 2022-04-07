package com.troc.service.impl;

import com.troc.dto.ProductDTO;
import com.troc.entity.Product;
import com.troc.exceptions.ProductNotFoundException;
import com.troc.mapper.ProductMapper;
import com.troc.repository.ProductRepository;
import com.troc.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findAllProducts() {
       return productMapper.productToProductDTO(productRepository.findAll());
    }

    @Override
    public Product findProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException("Product not found by id = " + id);
        }
        return product.get();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}

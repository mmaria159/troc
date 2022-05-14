package com.troc.service.impl;

import com.troc.dto.ProductDTO;
import com.troc.entity.ECategory;
import com.troc.entity.ERegion;
import com.troc.entity.Product;
import com.troc.exceptions.ProductNotFoundException;
import com.troc.mapper.ProductMapper;
import com.troc.repository.ProductRepository;
import com.troc.service.ProductService;
import org.springframework.data.domain.Sort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public List<ProductDTO> findAllProducts() {
        return productMapper.mapToProductDTO(productRepository.findAll());
    }

    @Override
    @Transactional
    public List<ProductDTO> findAllProducts(String orderBy, Sort.Direction direction) {
        return productMapper
                .mapToProductDTO(productRepository
                        .findAllSortingProducts(Sort.by(direction, orderBy))
                        .orElseThrow(() -> new ProductNotFoundException("ERROR")));
    }

    @Override
    public ProductDTO findProduct(Long id) {
        return productMapper.mapToProductDTO(productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found by id: " + id)));
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found by id: " + id));
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

//    @Override
//    public List<ProductDTO> findProductsByCategoryName(ECategory category) {
//        return productMapper
//                .mapToProductDTO(productRepository.findProductsByCategory(category)
//                        .orElseThrow(() -> new ProductNotFoundException("Product not found by category name:" + category)));
//    }

//    @Override
//    public List<ProductDTO> findProductsByRegionName(ERegion region) {
//        return productMapper
//                .mapToProductDTO(productRepository.findProductsByRegion(region)
//                        .orElseThrow(() -> new ProductNotFoundException("Product not found by region name:" + region)));
//    }

    @Override
    public List<ProductDTO> findProductsByCategoryName(ECategory category) {
        List<Product> products = productRepository.findAll().stream().filter(product -> product.getCategory().getName() == category).collect(Collectors.toList());
        return productMapper.mapToProductDTO(products);
    }

    @Override
    public List<ProductDTO> findProductsByRegionName(ERegion region) {
        List<Product> products = productRepository.findAll().stream().filter(product -> product.getRegion().getName() == region).collect(Collectors.toList());
        return productMapper.mapToProductDTO(products);
    }


    @Override
    public List<Product> findNewestProducts(Product id) {
        return productRepository.findNewestProducts(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found by region name:" + id));
    }
}

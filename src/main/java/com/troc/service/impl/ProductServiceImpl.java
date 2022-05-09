package com.troc.service.impl;

import com.troc.dto.ProductDTO;
import com.troc.entity.*;
import com.troc.exceptions.ProductNotFoundException;
import com.troc.exceptions.UserNotFoundException;
import com.troc.mapper.ProductMapper;
import com.troc.repository.ProductRepository;
import com.troc.service.ProductService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
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
    public List<ProductDTO> findAllProducts(String orderBy, Sort.Direction direction) {
        return productMapper
                .productToProductDTO(productRepository
                        .findAllSortingProducts(Sort.by(direction, orderBy))
                        .orElseThrow(()-> new ProductNotFoundException("ERROR")));
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

//    public Product saveProduct(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws ProductNotFoundException, IOException {
//        Image image1;
//        Image image2;
//        Image image3;
//        if (file1.getSize() != 0) {
//            image1 = toImageEntity(file1);
//            image1.setPreviewImage(true);
//            product.addImageToProduct(image1);
//        }
//        if (file2.getSize() != 0) {
//            image2 = toImageEntity(file2);
//            product.addImageToProduct(image2);
//        }
//        if (file3.getSize() != 0) {
//            image3 = toImageEntity(file3);
//            product.addImageToProduct(image3);
//        }
//
//        Product productFromDb = productRepository.save(product);
//        productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
//        return productRepository.save(product);
//    }

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

package com.troc.controller;

import com.troc.dto.ProductDTO;
import com.troc.entity.ECategory;
import com.troc.entity.ERegion;
import com.troc.entity.Product;
import com.troc.exceptions.ProductNotFoundException;
import com.troc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<ProductDTO>> findAllProducts() {
        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/sort")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<ProductDTO>> findAllSortingProducts(
            @RequestParam("orderBy") String orderBy, @RequestParam("direction") Sort.Direction direction) {
        return new ResponseEntity<>(productService.findAllProducts(orderBy, direction), HttpStatus.OK);
    }

    @GetMapping("/category")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<ProductDTO>> findProductsByCategoryName(@RequestParam("category") ECategory category) {
        return new ResponseEntity<>(productService.findProductsByCategoryName(category), HttpStatus.OK);
    }

    @GetMapping("/region")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<ProductDTO>> findProductsByRegionName(@RequestParam("region") ERegion region) {
        return new ResponseEntity<>(productService.findProductsByRegionName(region), HttpStatus.OK);
    }

    @GetMapping("/theNewest")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> findNewestProducts(@RequestParam("id") Product id) {
        return new ResponseEntity<>(productService.findNewestProducts(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ProductDTO findProduct(@PathVariable Long id) {
        return productService.findProduct(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) throws ProductNotFoundException {
        productService.saveProduct(product);
        return product;
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }
}

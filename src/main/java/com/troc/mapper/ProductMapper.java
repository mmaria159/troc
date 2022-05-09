package com.troc.mapper;

import com.troc.dto.ProductDTO;
import com.troc.entity.Product;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductDTO productToProductDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .description(product.getDescription())
                .name(product.getName())
                .dateOfCreated(product.getDateOfCreated())
                .category(product.getCategory())
                .region(product.getRegion())
                .build();
    }

    public List<ProductDTO> productToProductDTO(List<Product> products) {
        return products.stream().map(this::productToProductDTO).collect(Collectors.toList());
    }
}

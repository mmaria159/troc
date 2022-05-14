package com.troc.mapper;

import com.troc.dto.ImageDTO;
import com.troc.dto.ProductDTO;
import com.troc.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    private final ImageMapper imageMapper;

    public ProductDTO mapToProductDTO(Product product) {
        List<ImageDTO> images = imageMapper.mapToImageDto(product.getImages());
        if (images == null) images = Collections.emptyList();
        return ProductDTO.builder()
                .id(product.getId())
                .description(product.getDescription())
                .name(product.getName())
                .dateOfCreated(product.getDateOfCreated())
                .moreInformation(product.getMoreInformation())
                .category(product.getCategory())
                .region(product.getRegion())
                .images(images)
                .build();
    }

    public List<ProductDTO> mapToProductDTO(List<Product> products) {
        return products.stream().map(this::mapToProductDTO).collect(Collectors.toList());
    }
}

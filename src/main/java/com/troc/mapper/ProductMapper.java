package com.troc.mapper;

import com.troc.dto.AddressDTO;
import com.troc.dto.ProductDTO;
import com.troc.entity.Address;
import com.troc.entity.Product;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public ProductDTO productToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setDescription(product.getDescription());
        productDTO.setName(product.getName());
        productDTO.setDateOfAddition(new Date());

        return productDTO;
    }

    public List<ProductDTO> productToProductDTO(List<Product> products) {
        return products.stream().map(this::productToProductDTO).collect(Collectors.toList());
    }
}

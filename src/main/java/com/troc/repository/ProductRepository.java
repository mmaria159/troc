package com.troc.repository;

import com.troc.dto.ProductDTO;
import com.troc.entity.ECategory;
import com.troc.entity.ERegion;
import com.troc.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Date;
import java.util.List;
import java.util.Optional;
public interface ProductRepository extends JpaRepository<Product,Long> {
     @Query("SELECT p FROM Product p WHERE p.category.category=:category")
     Optional<List<Product>> findProductsByCategory(ECategory category);

     @Query("SELECT p FROM Product p WHERE p.region.region=:region")
     Optional<List<Product>> findProductsByRegion(ERegion region);

     @Query("SELECT p FROM Product p ORDER BY p.id asc")
     Optional<List<Product>> findNewestProducts(Product id );
     @Query(value = "SELECT p FROM Product p")
     Optional<List<Product>> findAllSortingProducts(Sort sort);
}

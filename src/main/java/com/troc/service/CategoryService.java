package com.troc.service;

import com.troc.dto.ProductDTO;
import com.troc.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();
}

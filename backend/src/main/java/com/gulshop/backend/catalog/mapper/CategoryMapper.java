package com.gulshop.backend.catalog.mapper;

import com.gulshop.backend.catalog.dto.CategoryResponse;
import com.gulshop.backend.catalog.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryResponse toResponse(Category category) {
        return new CategoryResponse(
            category.getId(),
            category.getName(),
            category.getSlug(),
            category.getDescription()
        );
    }
}

package com.gulshop.backend.catalog.mapper;

import com.gulshop.backend.catalog.dto.ProductResponse;
import com.gulshop.backend.catalog.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final CategoryMapper categoryMapper;

    public ProductResponse toResponse(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getSlug(),
            product.getDescription(),
            product.getPrice(),
            product.getStockQuantity(),
            product.isEnabled() && product.getStockQuantity() > 0,
            categoryMapper.toResponse(product.getCategory())
        );
    }
}

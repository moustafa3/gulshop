package com.gulshop.backend.catalog.service;

import com.gulshop.backend.catalog.dto.CategoryResponse;
import com.gulshop.backend.catalog.dto.ProductResponse;
import com.gulshop.backend.catalog.entity.Product;
import com.gulshop.backend.catalog.mapper.CategoryMapper;
import com.gulshop.backend.catalog.mapper.ProductMapper;
import com.gulshop.backend.catalog.repository.CategoryRepository;
import com.gulshop.backend.catalog.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CatalogService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final CategoryMapper categoryMapper;
    private final ProductMapper productMapper;

    public Page<CategoryResponse> getCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable)
            .map(categoryMapper::toResponse);
    }

    public Page<ProductResponse> getProducts(String search, Pageable pageable) {
        Page<Product> products;

        if (search == null || search.isBlank()) {
            products = productRepository.findAll(pageable);
        } else {
            products = productRepository.findByNameContainingIgnoreCase(search.trim(), pageable);
        }

        return products.map(productMapper::toResponse);
    }

    public ProductResponse getProductBySlug(String slug) {
        Product product = productRepository.findBySlug(slug)
            .orElseThrow(() -> new IllegalArgumentException("Produit introuvable"));

        return productMapper.toResponse(product);
    }
}

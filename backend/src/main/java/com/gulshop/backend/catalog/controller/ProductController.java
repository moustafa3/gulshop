package com.gulshop.backend.catalog.controller;

import com.gulshop.backend.catalog.dto.ProductResponse;
import com.gulshop.backend.catalog.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final CatalogService catalogService;

    @GetMapping
    public Page<ProductResponse> getProducts(Pageable pageable) {
        return catalogService.getProducts(pageable);
    }

    @GetMapping("/{slug}")
    public ProductResponse getProductBySlug(@PathVariable String slug) {
        return catalogService.getProductBySlug(slug);
    }
}

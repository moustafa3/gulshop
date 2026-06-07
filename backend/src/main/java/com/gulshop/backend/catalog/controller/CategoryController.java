package com.gulshop.backend.catalog.controller;

import com.gulshop.backend.catalog.dto.CategoryResponse;
import com.gulshop.backend.catalog.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CatalogService catalogService;

    @GetMapping
    public Page<CategoryResponse> getCategories(Pageable pageable) {
        return catalogService.getCategories(pageable);
    }
}

package com.gulshop.backend.catalog.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponse(
    UUID id,
    String name,
    String slug,
    String description,
    BigDecimal price,
    Integer stockQuantity,
    Boolean available,
    CategoryResponse category
) {
}

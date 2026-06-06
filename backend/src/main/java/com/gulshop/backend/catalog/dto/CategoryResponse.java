package com.gulshop.backend.catalog.dto;

import java.util.UUID;

public record CategoryResponse(
    UUID id,
    String name,
    String slug,
    String description
) {
}

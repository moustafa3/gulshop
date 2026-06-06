package com.gulshop.backend.auth.dto;

import java.util.UUID;

public record CurrentUserResponse(
    UUID userId,
    String email,
    String firstName,
    String lastName,
    String role
) {
}

package com.gulshop.backend.catalog.repository;

import com.gulshop.backend.catalog.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    Optional<Product> findBySlug(String slug);
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);

    boolean existsBySlug(String slug);
}

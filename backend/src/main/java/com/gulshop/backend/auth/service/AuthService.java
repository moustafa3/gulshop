package com.gulshop.backend.auth.service;

import com.gulshop.backend.auth.dto.AuthResponse;
import com.gulshop.backend.auth.dto.RegisterRequest;
import com.gulshop.backend.user.entity.User;
import com.gulshop.backend.user.entity.UserRole;
import com.gulshop.backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Un compte existe déjà avec cet email");
        }

        LocalDateTime now = LocalDateTime.now();

        User user = new User();
        user.setId(UUID.randomUUID());
        user.setEmail(request.email().toLowerCase().trim());
        user.setPasswordHash(passwordEncoder.encode(request.password()));
        user.setFirstName(request.firstName().trim());
        user.setLastName(request.lastName().trim());
        user.setRole(UserRole.CUSTOMER);
        user.setEnabled(true);
        user.setCreatedAt(now);
        user.setUpdatedAt(now);

        User savedUser = userRepository.save(user);

        return new AuthResponse(
            savedUser.getId(),
            savedUser.getEmail(),
            savedUser.getRole().name(),
            null
        );
    }
}

package com.gulshop.backend.auth.service;

import com.gulshop.backend.auth.dto.AuthResponse;
import com.gulshop.backend.auth.dto.RegisterRequest;
import com.gulshop.backend.user.entity.User;
import com.gulshop.backend.user.entity.UserRole;
import com.gulshop.backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.gulshop.backend.auth.dto.LoginRequest;
import com.gulshop.backend.security.JwtService;
import com.gulshop.backend.auth.dto.CurrentUserResponse;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

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

        String token = jwtService.generateToken(savedUser);

        return new AuthResponse(
            savedUser.getId(),
            savedUser.getEmail(),
            savedUser.getRole().name(),
            token
        );
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email().toLowerCase().trim())
            .orElseThrow(() -> new IllegalArgumentException("Email ou mot de passe incorrect"));

        if (!passwordEncoder.matches(request.password(), user.getPasswordHash())) {
            throw new IllegalArgumentException("Email ou mot de passe incorrect");
        }

        if (!user.isEnabled()) {
            throw new IllegalArgumentException("Ce compte est désactivé");
        }

        String token = jwtService.generateToken(user);

        return new AuthResponse(
            user.getId(),
            user.getEmail(),
            user.getRole().name(),
            token
        );
    }
    public CurrentUserResponse getCurrentUser(String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException("Utilisateur introuvable"));

        return new CurrentUserResponse(
            user.getId(),
            user.getEmail(),
            user.getFirstName(),
            user.getLastName(),
            user.getRole().name()
        );
    }

}

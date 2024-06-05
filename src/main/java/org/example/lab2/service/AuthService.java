package org.example.lab2.service;

import org.example.lab2.entity.dto.request.LoginRequest;
import org.example.lab2.entity.dto.request.RefreshTokenRequest;
import org.example.lab2.entity.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
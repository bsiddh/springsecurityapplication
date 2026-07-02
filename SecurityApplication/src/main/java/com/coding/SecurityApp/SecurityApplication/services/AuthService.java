package com.coding.SecurityApp.SecurityApplication.services;

import com.coding.SecurityApp.SecurityApplication.dto.LoginDto;
import com.coding.SecurityApp.SecurityApplication.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    public String login(LoginDto loginDto) {
        Authentication authentication =   authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword())
        );
        User user = (User) authentication.getPrincipal();
        String token = jwtService.generateToken(user);

        return token;
    }
}

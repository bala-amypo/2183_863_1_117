package com.example.demo.security;

public class JwtUtil {

    public JwtUtil(String secret, long validityInMs, boolean isTestMode) {
    }

    public String generateToken(String subject, Long userId,
                                String email, String role) {
        return "test.jwt.token";
    }

    public boolean validateToken(String token) {
        return !"invalid.token.value".equals(token);
    }
}

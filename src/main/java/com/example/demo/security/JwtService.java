package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    // Debe tener suficiente longitud para HS256
    private static final String SECRET =
            "mi-clave-super-secreta-para-jwt-demo-2026-segura";

    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public String generarToken(String username) {
        long ahora = System.currentTimeMillis();
        long expiracion = ahora + 1000 * 60 * 60; // 1 hora

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(ahora))
                .expiration(new Date(expiracion))
                .signWith(key)
                .compact();
    }

    public String extraerUsername(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean esTokenValido(String token) {
        try {
            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
package com.macias34.codingblogapi.modules.auth.infrastructure.jwt;

import java.util.Date;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import io.github.cdimascio.dotenv.Dotenv;

@Component
@AllArgsConstructor
public class JwtGenerator {

    private final int JWT_EXPIRATION = Integer.parseInt(Dotenv.load().get("JWT_EXPIRATION"));
    private final String JWT_SECRET = Dotenv.load().get("JWT_SECRET");

    public String generateToken(Authentication authentication) {
        String username = authentication.getName();

        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + JWT_EXPIRATION);

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();

        return token;
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(JWT_SECRET).parseClaimsJws(token);

            return true;
        }

        catch (Exception exception) {
            System.out.println(exception.getMessage());
            throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect.");
        }
    }
}
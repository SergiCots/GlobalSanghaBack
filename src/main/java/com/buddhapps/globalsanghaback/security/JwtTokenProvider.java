package com.buddhapps.globalsanghaback.security;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.buddhapps.globalsanghaback.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Autowired
    private UserDetailsService userDetailsService;


    // Este debería ser un valor secreto almacenado de manera segura
    private final String SECRET_KEY = "TuSecretoMuySeguro";

    // Método para generar un token JWT
    public String generateToken(User user) {
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 864000000)) // 10 días
                .sign(Algorithm.HMAC512(SECRET_KEY.getBytes()));
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public boolean validateToken(String token) {
        try {
            JWT.require(Algorithm.HMAC512(SECRET_KEY.getBytes()))
                    .build()
                    .verify(token);
            return true;
        } catch (Exception e) {
            // Log o manejo de excepción
            return false;
        }
    }

    public Authentication getAuthentication(String token) {
        DecodedJWT jwt = JWT.require(Algorithm.HMAC512(SECRET_KEY.getBytes()))
                .build()
                .verify(token);
        String username = jwt.getSubject();

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

}


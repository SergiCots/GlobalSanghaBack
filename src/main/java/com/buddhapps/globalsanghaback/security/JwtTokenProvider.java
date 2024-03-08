package com.buddhapps.globalsanghaback.security;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.buddhapps.globalsanghaback.model.User;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    // Este debería ser un valor secreto almacenado de manera segura
    private final String SECRET_KEY = "TuSecretoMuySeguro";

    // Método para generar un token JWT
    public String generateToken(User user) {
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 864000000)) // 10 días
                .sign(Algorithm.HMAC512(SECRET_KEY.getBytes()));
    }
}


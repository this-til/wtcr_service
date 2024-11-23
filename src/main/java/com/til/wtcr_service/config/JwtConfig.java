package com.til.wtcr_service.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;

@Configuration
public class JwtConfig implements WebMvcConfigurer {

    @Value("${jwt.salt}")
    private String salt;

    public String generateJwt() {
        return JWT.create()
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 8))
                .sign(Algorithm.HMAC256(salt));
    }

    public void parseJwt(String jwt) {
        JWT.require(Algorithm.HMAC256(salt))
                .build()
                .verify(jwt);
    }

}

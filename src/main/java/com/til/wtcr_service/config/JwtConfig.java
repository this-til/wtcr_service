package com.til.wtcr_service.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.til.wtcr_service.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;

@Configuration
public class JwtConfig implements WebMvcConfigurer {

    public static final String TOKEN = "token";
    public static final String USER_ID = "user_id";
    public static final String USER_PERMISSION = "user_permission";

    @Value("${jwt.salt}")
    private String salt;


    public String generateJwt(User user) {
        return JWT.create()
                .withClaim(USER_ID, user.getId())
                .withClaim(USER_PERMISSION, user.getPermission().getId())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 8))
                .sign(Algorithm.HMAC256(salt));
    }

    /***
     * 验证令牌，返回当前能录用户的id
     */
    public int parseJwt(String jwt) {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(salt))
                .build()
                .verify(jwt);
        return verify.getClaim(USER_ID).asInt();
    }

}

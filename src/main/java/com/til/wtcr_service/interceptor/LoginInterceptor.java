package com.til.wtcr_service.interceptor;

import com.til.wtcr_service.config.JwtConfig;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;

@Controller
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private JwtConfig jwtConfig;

    @Override
    public boolean preHandle(final @NotNull HttpServletRequest request, final @NotNull HttpServletResponse response, final @NotNull Object handler) throws Exception {
        String header = request.getHeader(JwtConfig.TOKEN);
        try {
            jwtConfig.parseJwt(header);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

package com.example.family.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class ApiKeyConfig implements WebMvcConfigurer {

    private static final String API_KEY_HEADER = "X-API-Key";
    private static final String VALID_API_KEY = "apieceofmines-prod-key-2026";

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                String path = request.getRequestURI();

                // Exempt health check from auth
                if (path.equals("/api/health")) {
                    return true;
                }

                // Check API key for protected endpoints
                String apiKey = request.getHeader(API_KEY_HEADER);
                if (apiKey == null || !apiKey.equals(VALID_API_KEY)) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.setContentType("application/json");
                    response.getWriter().write("{\"error\":\"Invalid or missing API key\"}");
                    return false;
                }

                return true;
            }
        }).addPathPatterns("/api/**").excludePathPatterns("/api/health");
    }
}

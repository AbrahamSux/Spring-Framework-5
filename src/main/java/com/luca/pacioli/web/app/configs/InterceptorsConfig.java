package com.luca.pacioli.web.app.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorsConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("horarioClientesInterceptor")
    private HandlerInterceptor horarioClientesInterceptor;



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*registry.addInterceptor(horarioClientesInterceptor).addPathPatterns(
                "/app/index/**",
                "/app/**"
        );*/

        registry.addInterceptor(horarioClientesInterceptor).excludePathPatterns("/app/saliendo");
    }

}

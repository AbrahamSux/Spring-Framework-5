package com.luca.pacioli.web.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    private final static Logger LOGGER = LoggerFactory.getLogger(MvcConfig.class);

    /**
     * Método utilizado para agregar directorios/recursos estáticos al proyecto.
     *
     * @param registry
     */
    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);

        String resourcePath = Paths.get("uploads").toAbsolutePath().toUri().toString();

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("> resourcePath( {} )", resourcePath);
        }

        registry.addResourceHandler("/uploads/**").addResourceLocations(resourcePath);
    }*/

}

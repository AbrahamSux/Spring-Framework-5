package com.luca.pacioli.web.app.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:leyendas.properties")
})
public class ApplicationProperties {
}

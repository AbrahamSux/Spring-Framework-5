package com.luca.pacioli.web.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @description Clase de configuración para los Archivos de Propiedades.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 19/05/2021 13:10:00 hrs.
 * @version 0.1
 */
@Configuration
@PropertySources({
        @PropertySource("classpath:leyendas.properties")
})
public class ApplicationProperties {
}

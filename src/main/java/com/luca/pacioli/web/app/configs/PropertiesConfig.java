/*
 * Proyecto:        Facturación - WebApp del Sistema de Facturación
 * Abraham Juárez S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.luca.pacioli.web.app.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @description Clase para la configuración de los archivos de Propiedades.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 18/05/2021 17:59:00 hrs.
 * @version 0.1
 */
@Configuration
@PropertySources({
        @PropertySource("classpath:leyendas.properties")
})
public class PropertiesConfig {
}

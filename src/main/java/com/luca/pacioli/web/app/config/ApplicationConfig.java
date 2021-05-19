/*
 * Proyecto:        Facturación - WebApp del Sistema de Facturación
 * Abraham Juárez S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.luca.pacioli.web.app.config;

import com.luca.pacioli.web.app.services.NuevoService;
import com.luca.pacioli.web.app.services.impl.NuevoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description Clase de configuración para Beans no mapeados por anotaciones.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 19/05/2021 12:51:00 hrs.
 * @version 0.1
 */
@Configuration
public class ApplicationConfig {

    @Bean("nuevoService")
    public NuevoService nuevoService() {
        return new NuevoServiceImpl();
    }

}

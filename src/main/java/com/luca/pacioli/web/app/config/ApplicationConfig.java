/*
 * Proyecto:        Facturación - WebApp del Sistema de Facturación
 * Abraham Juárez S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.luca.pacioli.web.app.config;

import com.luca.pacioli.web.app.models.ItemFactura;
import com.luca.pacioli.web.app.models.Producto;
import com.luca.pacioli.web.app.services.NuevoService;
import com.luca.pacioli.web.app.services.impl.NuevoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

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

    @Bean("itemsFacturaLenovo")
    public List<ItemFactura> itemsFactura() {
        List<ItemFactura> items = Arrays.asList(
                new ItemFactura(new Producto("Laptop Lenovo", 35000.99), 1),
                new ItemFactura(new Producto("Impresora Lenovo", 4680.99), 1),
                new ItemFactura(new Producto("Mouse Lenovo", 250.00), 2)
        );

        return items;
    }

}

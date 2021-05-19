/*
 * Proyecto:        Facturación - WebApp del Sistema de Facturación
 * Abraham Juárez S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.luca.pacioli.web.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description Clase Controladora que nos direcciona a la página de incio.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 18/05/2021 19:11:00 hrs.
 * @version 0.1
 */
@Controller
public class HomeController {

    /**
     * Utilizada para manipular los mensajes informativos y de error.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);



    // METODOS

    @GetMapping("/")
    public String home() {
        LOGGER.info(">>> home()");

        //TODO: "redirect" nos redirecciona a una nueva página y nueva petición HTTP, se puede utilizar para páginas
        // externas como lo son Google (www.google.com).

        //TODO: "forward" realiza un despacho dentro del mismo request sin recargar la página, sin recargar el request,
        // por lo tanto los parámetros del request no se pierden. Se utiliza para rutas internas (de controladores).

        return "forward:/facturacion/index";
    }

}

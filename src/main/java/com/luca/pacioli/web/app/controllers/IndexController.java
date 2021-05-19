/*
 * Proyecto:        Facturación - WebApp del Sistema de Facturación
 * Abraham Juárez S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.luca.pacioli.web.app.controllers;

import com.luca.pacioli.web.app.services.IndexService;
import com.luca.pacioli.web.app.services.NuevoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description Clase Controladora para la página de incio.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 19/05/2021 10:16:00 hrs.
 * @version 0.3
 */
@Controller
public class IndexController {

    /**
     * Utilizada para manipular los mensajes informativos y de error.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);


    /**
     * Referencia al Service {@link IndexService}
     */
    @Autowired
    @Qualifier("indexService")
    private IndexService indexService;

    /**
     * Referencia al Service {@link NuevoService}
     */
    @Autowired
    private NuevoService nuevoService;



    // METODOS

    /**
     * Método encargado de re-direccionar a la vista principal.
     *
     * @return view index.
     */
    @GetMapping({"", "/", "/index", "/inicio", "/home"})
    public String index(Model model) {
        LOGGER.info(">>> index() ");

        //TODO: las clases mapeadas con BEAN en la configuración se recomienda más usarlas para aplicaciones externas (consumo de
        // APIs, etc.), y las mapeadas con ANOTACIONES se recomienda más en clases internas (nuestros daos, etc.).

        // SE ACCEDE AL MÉTODO MAPEADO EN LA CONFIGURACIÓN A TRAVÉS DE BEAN
        model.addAttribute("encabezadoBean", "Método mapeado desde la configuración mediante -> @Bean");
        model.addAttribute("objectBean", nuevoService.otherMessage() );

        // SE ACCEDE AL MÉTODO MAPEADO CON LAS ANOTACIONES
        model.addAttribute("encabezadoAnnotation", "Método mapeado mediante anotaciones -> @Service");
        model.addAttribute("objectAnnotation", indexService.testMessage("Texto enviado"));

        return "index";
    }

}

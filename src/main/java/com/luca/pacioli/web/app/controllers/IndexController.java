/*
 * Proyecto:        Facturación - WebApp del Sistema de Facturación
 * Abraham Juárez S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.luca.pacioli.web.app.controllers;

import com.luca.pacioli.web.app.services.IndexService;
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
 * @version 0.2
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



    // METODOS

    /**
     * Método encargado de re-direccionar a la vista principal.
     *
     * @return view index.
     */
    @GetMapping({"", "/", "/index", "/inicio", "/home"})
    public String index(Model model) {
        LOGGER.info(">>> index() ");

        //model.addAttribute("object", indexService.testMessage() );
        model.addAttribute("object", indexService.testMessage("Texto enviado"));

        return "index";
    }

}

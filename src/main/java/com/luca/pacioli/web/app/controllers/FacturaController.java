package com.luca.pacioli.web.app.controllers;

import com.luca.pacioli.web.app.models.Factura;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description Clase Controladora para la Factura.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 19/05/2021 16:01:00 hrs.
 * @version 0.1
 */
@Controller
@RequestMapping("/factura")
public class FacturaController {

    /**
     * Utilizada para manipular los mensajes informativos y de error.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(FacturaController.class);


    @Autowired
    private Factura factura;



    // METODOS

    @GetMapping("/mostrar")
    public String mostrar(Model model) {
        LOGGER.info(">>> mostrar() ");

        model.addAttribute("titulo", "Factura de Productos Lenovo");
        model.addAttribute("factura", factura);


        return "factura/mostrar";
    }
}

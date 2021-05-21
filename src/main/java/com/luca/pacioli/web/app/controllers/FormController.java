package com.luca.pacioli.web.app.controllers;

import com.luca.pacioli.web.app.models.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormController.class);

    @GetMapping("/form")
    public String obtenerForm(Model model) {
        LOGGER.info(">>> obtenerForm() ");

        model.addAttribute("formulario", "Formulario del Usuario");

        return "form";
    }

    @PostMapping("/form")
    public String procesarForm(Usuario usuario,
                               Model model) {
        LOGGER.info(">>> procesarForm( " + usuario.toString() + " ) ");

        model.addAttribute("titulo", "Datos del Usuario");
        model.addAttribute("user", usuario);

        return "resultado";
    }

}

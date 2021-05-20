package com.luca.pacioli.web.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormController.class);

    @GetMapping("/form")
    public String obtenerForm(Model model) {

        model.addAttribute("formulario", "Formulario del Usuario");

        return "form";
    }

    @PostMapping("/form")
    public String procesarForm(@RequestParam(name = "username") String nombreUsuario,
                               @RequestParam(name = "password") String contrasenia,
                               @RequestParam(name = "email") String correo,
                               Model model) {
        LOGGER.info(">>> procesarForm( " + nombreUsuario + ", " + contrasenia + ", " + correo + " ) ");

        model.addAttribute("titulo", "Datos del Usuario");
        model.addAttribute("user", nombreUsuario);
        model.addAttribute("pass", contrasenia);
        model.addAttribute("em", correo);

        return "resultado";
    }

}

package com.luca.pacioli.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class AppController {

    @GetMapping({"/", "index"})
    public String index(Model model) {

        model.addAttribute("titulo", "Clientes");
        model.addAttribute("subtitulo", "Bienvenido al horario de atencion a Clientes!");

        return "index";
    }

}

package com.luca.pacioli.web.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class AppController {

    @Value("${config.horario.apertura}")
    private Integer valueApertura;

    @Value("${config.horario.cierre}")
    private Integer valueCierre;



    @GetMapping({"/", "index"})
    public String index(Model model) {

        model.addAttribute("titulo", "Clientes");
        model.addAttribute("subtitulo", "Bienvenido al horario de atencion a Clientes!");

        return "index";
    }

    @GetMapping("/saliendo")
    public String cerrando(Model model) {
        StringBuilder mensaje = new StringBuilder("Cerrado, por favor visitenos desde las");
        mensaje.append(valueApertura);
        mensaje.append(" hrs. hasta las ");
        mensaje.append(valueCierre);
        mensaje.append(" hrs.");

        model.addAttribute("titulo", "Exit");
        model.addAttribute("subtitulo", "Fuera del horario de atención.");
        model.addAttribute("mensaje", mensaje);

        return "exit";
    }

}

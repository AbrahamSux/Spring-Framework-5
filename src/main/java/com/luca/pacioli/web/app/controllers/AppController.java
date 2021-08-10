package com.luca.pacioli.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({"/", "/index"})
    public String index() {

        // ERRORES Arithmetic.
        int value = 100/0;

        // ERRORES NumberFormat
        //int value = Integer.parseInt("10x");

        return "index";
    }

}

package com.luca.pacioli.web.app.controllers;

import com.luca.pacioli.web.app.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClienteController {

    @Autowired
    @Qualifier("clienteRepository")
    private ClienteService clienteService;



    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public String listarClientes(Model model) {
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clienteService.findAll());

        return "mostrar";
    }

}

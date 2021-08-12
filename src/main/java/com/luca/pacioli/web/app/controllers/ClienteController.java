package com.luca.pacioli.web.app.controllers;

import com.luca.pacioli.web.app.models.entity.Cliente;
import com.luca.pacioli.web.app.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ClienteController {

    @Autowired
    @Qualifier("clienteServiceImpl")
    private ClienteService clienteService;


    /**
     * Método encargado de mostrar todos los clientes.
     *
     * @param model Modelo para pasar los datos a la vista.
     * @return Retorna la vista 'mostrar'.
     */
    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public String listarClientes(Model model) {
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clienteService.findAll());

        return "mostrar";
    }

    /**
     * Método encargado de cargar el formulario.
     *
     * @param model Modelo para pasar los datos a la vista.
     * @return Retorna la vista 'form'.
     */
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String crearCliente(Map<String, Object> model) {
        model.put("titulo", "Formulario del cliente");
        model.put("cliente", new Cliente());

        return "form";
    }

    /**
     * Método encargado de guardar los datos mandados a través del fomulario.
     *
     * @param cliente Cliente a guardar.
     * @return Redirecciona a la vista 'clientes'.
     */
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);

        return "redirect:/clientes";
    }

}

package com.luca.pacioli.web.app.controllers;

import com.luca.pacioli.web.app.models.entity.Cliente;
import com.luca.pacioli.web.app.services.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);


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
    public String cargarFormularioCliente(Map<String, Object> model) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> cargarFormularioCliente()");
        }

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
    public String guardarCliente(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes flash,
                                 SessionStatus status) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> guardarCliente( {} )", cliente.toString() );
        }

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario del cliente");

            return "form";
        }

        String messageFlash = ((cliente.getId() == null)? "Cliente creado existosamente!" : "Cliente editado existosamente!");

        clienteService.save(cliente);

        // SE COMPLETA EL PROCESAMIENTO DE LA SESIÓN, LO QUE PERMITE LA LIMPIEZA DE LOS ATRIBUTOS DE LA SESIÓN.
        status.setComplete();

        // Flash Messenger
        flash.addFlashAttribute("success", messageFlash);

        return "redirect:/clientes";
    }

    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public String editarCliente(@PathVariable(value = "id") Long identificador, ModelMap modelMap, RedirectAttributes flash) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> editarCliente( {} )", identificador );
        }

        Cliente cliente = null;

        if (identificador <= 0) {
            flash.addFlashAttribute("danger", "El identificador no es válido, ID : " + identificador);

            return "redirect:/clientes";
        }

        cliente = clienteService.findOne(identificador);

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Cliente a Editar : {}", ((cliente != null) ? cliente.toString() : "NULL") );
        }

        if (cliente != null) {
            modelMap.addAttribute("titulo", "Editar cliente");
            modelMap.addAttribute("cliente", cliente);
        } else {
            flash.addFlashAttribute("danger", "Falló al momento de buscar al cliente con ID : " + identificador);

            return "redirect:/clientes";
        }

        return "form";
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
    public String eliminarCliente(@PathVariable(value = "id") Long identificador, RedirectAttributes flash) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> eliminarCliente( {} )", identificador );
        }

        if (identificador <= 0) {
            return "redirect:/clientes";
        }

        clienteService.delete(identificador);

        // Flash Messenger
        flash.addFlashAttribute("success", "Cliente eliminado existosamente!");

        return "redirect:/clientes";
    }

}

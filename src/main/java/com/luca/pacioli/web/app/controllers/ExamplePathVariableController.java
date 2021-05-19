/*
 * Proyecto:        Facturación - WebApp del Sistema de Facturación
 * Abraham Juárez S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.luca.pacioli.web.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;

/**
 * @description Clase Controladora para validación del funcionamiento de @PathVariable.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 18/05/2021 13:30:00 hrs.
 * @version 0.2
 */
@Controller
@RequestMapping("/path")
public class ExamplePathVariableController {

    /**
     * Utilizada para manipular los mensajes informativos y de error.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExamplePathVariableController.class);


    @Value("${controller.variables.encabezado.index}")
    private String encabezadoIndex;

    @Value("${controller.variables.encabezado.variable}")
    private String encabezadoVariable;

    @Value("${controller.variables.encabezado.variables}")
    private String encabezadoVariables;



    // METODOS

    /**
     * Método encargado de re-direccionar a la vista de inicio del folder 'variables'.
     *
     * @return view index.
     */
    @GetMapping("/")
    public String index(ModelMap mm) {
        LOGGER.info(">>> index()");

        mm.addAttribute("encabezado", encabezadoIndex);

        return "variables/index";
    }

    /**
     * Método encargado e re-direccionar a la vista mostrar para visualizar el parámetro recibido.
     * URL: http://localhost:8086/path/variable/Hola M Supernova
     *
     * @param nombreUsuario Nombre del Usuario.
     * @return view mostrar.
     */
    @GetMapping("/variable/{username}")
    public ModelAndView variable(@PathVariable(name = "username") String nombreUsuario, ModelAndView mv) {
        LOGGER.info(">>> variable( " + ((nombreUsuario != null) ? nombreUsuario : "NULL") + " )");

        // SE ESTABLECE LA VISTA A DIRECCIONAR.
        mv.setViewName("variables/mostrar");

        mv.addObject("encabezado", encabezadoVariable);
        mv.addObject("user", "El Nombre de Usuario recibido fue: " + nombreUsuario);

        return mv;
    }

    /**
     * Método encargado e re-direccionar a la vista mostrar para visualizar los parámetros recibidos.
     * URL: http://localhost:8086/path/variables/Ernesto Juárez/5517639196
     *
     * @param nombreUsuario Nombre del Usuario.
     * @return view mostrar.
     */
    @GetMapping("/variables/{username}/{number}")
    public ModelAndView variables(@PathVariable(name = "username") String nombreUsuario,
                                 @PathVariable(name = "number") BigInteger numero,
                                 ModelAndView mv) {
        LOGGER.info(">>> variables( " + nombreUsuario + ", " + numero + " )");

        // SE ESTABLECE LA VISTA A DIRECCIONAR.
        mv.setViewName("variables/mostrar");

        mv.addObject("encabezado", encabezadoVariables);
        mv.addObject("user", "El número de telefono del usuario '"
                + nombreUsuario +"' es: " + numero );

        return mv;
    }

}

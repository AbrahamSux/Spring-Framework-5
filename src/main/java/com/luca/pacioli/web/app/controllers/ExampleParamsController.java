/*
 * Proyecto:        Facturación - WebApp del Sistema de Facturación
 * Abraham Juárez S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.luca.pacioli.web.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description Clase Controladora para validación del funcionamiento de Params.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 18/05/2021 09:58:00 hrs.
 * @version 0.1
 */
@Controller
@RequestMapping("/params")
public class ExampleParamsController {
	
	/**
     * Utilizada para manipular los mensajes informativos y de error.
     */
	private static final Logger LOGGER = LoggerFactory.getLogger(ExampleParamsController.class);
	
	
	
	// MÉTODOS 
	
	/**
	 * Método encargado de mostrar el valor recibido en la vista de mostrar.
	 * URL: http://localhost:8086/params/string?text=Abraham
	 * 
	 * @param texto Argumento recibido.
	 * @return view mostrar.
	 */
	@GetMapping("/string")
	public ModelAndView param(@RequestParam(name = "text", required = false, defaultValue = "NULL") String texto, ModelAndView mv) {
		LOGGER.info(">>> param( " + ((texto!=null) ? texto : "NULL") + " )");

		mv.setViewName("params/mostrar");
		mv.addObject("encabezado", "Parámetro Recibido del Request HTTP GET - URL");
		mv.addObject("argument", "El valor recibido fue: " + texto);
		
		return mv;
	}

	/**
	 * Método encargado de re-direccionar a la vista de inicio del folder 'params'.
	 *
	 * @return view index.
	 */
	@GetMapping("/")
	public String index(ModelMap mm) {
		LOGGER.info(">>> index()");

		mm.addAttribute("encabezado", "Envío de Parámetros por Request HTTP GET - URL");

		return "params/index";
	}

}

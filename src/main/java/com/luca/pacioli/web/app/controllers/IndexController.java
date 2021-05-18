/*
 * Proyecto:        Facturación - WebApp del Sistema de Facturación
 * Abraham Juárez S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.luca.pacioli.web.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description Clase Controladora para la página de inicio de la aplicación.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 17/05/2021 19:34:00 hrs.
 * @version 0.1
 */
@Controller
public class IndexController {
	
	/**
     * Utilizada para manipular los mensajes informativos y de error.
     */
	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
	
	
	
	// METODOS
	
	/**
	 * Método encargado de redireccionar a la vista principal.
	 * 
	 * @return view
	 */
	@GetMapping({"/index", "/", "/home"})
	public String index() {
		LOGGER.info(">>> index()");
		
		return "index";
	}

}

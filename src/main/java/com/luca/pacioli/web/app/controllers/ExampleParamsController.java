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

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;

/**
 * @description Clase Controladora para validación del funcionamiento de Params.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 18/05/2021 09:58:00 hrs.
 * @version 0.2
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

	/**
	 * Método encargado de mostrar el valor recibido en la vista de mostrar.
	 * URL: http://localhost:8086/params/value-param?text=Abraham
	 * 
	 * @param texto Argumento recibido.
	 * @return view mostrar.
	 */
	@GetMapping("/value-param")
	public ModelAndView param(@RequestParam(name = "text", required = false, defaultValue = "NULL") String texto, ModelAndView mv) {
		LOGGER.info(">>> param( " + ((texto!=null) ? texto : "NULL") + " )");

		// SE ESTABLECE LA VISTA A DIRECCIONAR.
		mv.setViewName("params/mostrar");

		mv.addObject("encabezado", "Parámetro Recibido del Request HTTP GET - URL");
		mv.addObject("argument", "El valor recibido fue: " + texto);
		
		return mv;
	}

	/**
	 * Método encargado de mostrar los valores recibidos en la vista de mostrar.
	 * URL: http://localhost:8086/params/mix-params?name=Ernesto Juárez&number=5517639196
	 *
	 * @param nombre Nombre del usuario.
	 * @param numero Número del usuario.
	 * @return view mostrar.
	 */
	@GetMapping("/mix-params")
	public ModelAndView param(@RequestParam(name = "name", required = false, defaultValue = "NULL") String nombre,
							  @RequestParam(name = "number", required = false) BigInteger numero,
							  ModelAndView mv) {
		LOGGER.info(">>> param( " + nombre + ", " + ((numero!=null) ? numero : "NULL") + " )");

		// SE ESTABLECE LA VISTA A DIRECCIONAR.
		mv.setViewName("params/mostrar");

		mv.addObject("encabezado", "Parámetro Recibido del Request HTTP GET - URL");
		mv.addObject("argument", "El número de teléfono de '" + nombre + "' es : " + numero);

		return mv;
	}

	/**
	 * Método encargado de mostrar los valores recibidos en la vista de mostrar.
	 * URL: http://localhost:8086/params/mix-params-request?name=Ernesto Juárez&number=
	 *
	 * @param request Solicitud recibida.
	 * @return view mostrar.
	 */
	@GetMapping("/mix-params-request")
	public ModelAndView param(HttpServletRequest request, ModelAndView mv) {
		LOGGER.info(">>> param( " + request.getParameter("name") + ", " + request.getParameter("number") + " )");

		// SE ESTABLECE LA VISTA A DIRECCIONAR.
		mv.setViewName("params/mostrar");

		mv.addObject("encabezado", "Parámetro Recibido del Request HTTP GET - URL");
		mv.addObject("argument", "El número de teléfono de '"
				+ request.getParameter("name") + "' es : "
				+ ((request.getParameter("number").isEmpty()) ? "0" : request.getParameter("number")) );

		return mv;
	}

}

/*
 * Proyecto:        Facturación - WebApp del Sistema de Facturación
 * Abraham Juárez S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.luca.pacioli.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luca.pacioli.web.app.models.Usuario;

/**
 * @description Clase Controladora para la página de inicio de la aplicación.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 17/05/2021 19:34:00 hrs.
 * @version 0.5
 */
@Controller
@RequestMapping("/facturacion")
public class IndexController {
	
	/**
     * Utilizada para manipular los mensajes informativos y de error.
     */
	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
	
	
	
	// METODOS
	
	/**
	 * Método encargado de re-direccionar a la vista principal.
	 * 
	 * @return view index.
	 */
	@GetMapping({"/index", "/", "/home"})
	public String index(Model model) {
		LOGGER.info(">>> index()");
		
		model.addAttribute("titulo", "Home");
		model.addAttribute("mensajeBienvenida", "¡Bienvenido al Sistema de Facturación!");
		
		return "index";
	}
	
	/**
	 * Método encargado de re-direccionar a la vista del perfil.
	 * 
	 * @return view perfil.
	 */
	@GetMapping("/perfil")
	public String perfil(Model model) {
		LOGGER.info(">>> perfil()");
		
		Usuario usuario = new Usuario("Ernesto", "Juárez", "ernesto.juarez@gmail.com");
		
		model.addAttribute("encabezado", "Perfil del Usuario: ".concat(usuario.getNombre()));
		model.addAttribute("user", usuario);
		
		LOGGER.info("Datos Establecidos: {}", ((usuario != null) ? usuario.toString() : "NULL") );
		
		return "perfil";
	}
	
	/**
	 * Método encargado de re-direccionar a la vista de listar.
	 * 
	 * @return view listar.
	 */
	@GetMapping("/listar")
	public String listar(Model model) {
		LOGGER.info(">>> listar()");
		
		model.addAttribute("encabezado", "Lista de Usuarios");
		
		return "listar";
	}
	
	
	
	// METODOS PRIVADOS
	
	/**
	 * Método auxiliar encargado de establecer una lista de usuarios.
	 * 
	 * @return una lista de Usuarios.
	 */
	private List<Usuario> getLista() {
		List<Usuario> users = new ArrayList<>();
		users.add(new Usuario("Ernesto", "Juárez", null));
		users.add(new Usuario("Dalia", "de la Cruz", "dalia.delacruz@outlook.com"));
		users.add(new Usuario("Diana", "Camarillo", "diana.camarillo@gmail.com"));
		users.add(new Usuario("José", "Madero", "jose.madero@hotmail.com"));
		
		return users;
	}
	
	/**
	 * Método auxiliar utilizado para retornar una lista de usuarios a cualquier método
	 * del controlador Index.
	 * 
	 * @return lista de Usuarios.
	 */
	@ModelAttribute("users")
	public List<Usuario> obtenerUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios = getLista();
		
		LOGGER.info("Datos Establecidos: {}", ((usuarios != null) ? usuarios.toString() : "NULL") );
		
		return usuarios;
	}

}

/*
 * Proyecto:        Facturación - WebApp del Sistema de Facturación
 * Abraham Juárez S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.luca.pacioli.web.app.models;

/**
 * @description Clase modelo para el objeto Usuario.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 17/05/2021 21:31:00 hrs.
 * @version 0.1
 */
public class Usuario {
	
	private String nombre;
	
	private String apellidoPaterno;
	
	private String email;
	
	public Usuario() {
		super();
	}

	public Usuario(String nombre, String apellidoPaterno, String email) {
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", email=" + email + "]";
	}
	
}

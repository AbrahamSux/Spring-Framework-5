package com.luca.pacioli.web.app.models.entity;

import com.luca.pacioli.web.app.validations.annotation.IdentificadorSku;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


public class Usuario {

    @IdentificadorSku
    private String identificador;

    private String nombre;

    private String apellido;

    @Size(min = 5, max = 15)
    private String username;

    @Size(min = 8, max = 15)
    private String password;

    @Email
    private String email;

    @Min(10)
    @Max(10000)
    private Double cuenta;

    @Past
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date fechaNacimiento;

    @NotNull
    private Pais pais;

    @NotNull
    @Size(min = 1, max = 3)
    private List<Role> roles;

    private Boolean habilitar;

    private String genero;

    private String valorSecreto;

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getCuenta() {
        return cuenta;
    }

    public void setCuenta(Double cuenta) {
        this.cuenta = cuenta;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Boolean getHabilitar() {
        return habilitar;
    }

    public void setHabilitar(Boolean habilitar) {
        this.habilitar = habilitar;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getValorSecreto() {
        return valorSecreto;
    }

    public void setValorSecreto(String valorSecreto) {
        this.valorSecreto = valorSecreto;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "identificador='" + identificador + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", cuenta=" + cuenta +
                ", fechaNacimiento=" + fechaNacimiento +
                ", pais=" + pais +
                ", roles=" + roles +
                ", habilitar=" + habilitar +
                ", genero='" + genero + '\'' +
                ", valorSecreto='" + valorSecreto + '\'' +
                '}';
    }

}

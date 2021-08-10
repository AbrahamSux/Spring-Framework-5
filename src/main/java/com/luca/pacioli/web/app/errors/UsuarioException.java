package com.luca.pacioli.web.app.errors;

public class UsuarioException extends RuntimeException {

    public UsuarioException(String value) {
        super("El usuario con ID : ".concat(value).concat(", no existe en el sistema."));
    }
}

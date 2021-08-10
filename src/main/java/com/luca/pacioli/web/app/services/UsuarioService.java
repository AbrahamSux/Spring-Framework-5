package com.luca.pacioli.web.app.services;

import com.luca.pacioli.web.app.models.Usuario;

import java.util.List;

public interface UsuarioService {

    public List<Usuario> obtenerUsuarios();

    public Usuario obtenerPorId(Integer identificador);

}

package com.luca.pacioli.web.app.services;

import com.luca.pacioli.web.app.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public List<Usuario> obtenerUsuarios();

    public Usuario obtenerPorId(Integer identificador);

    public Optional<Usuario> obtenerPorIdOptional(Integer identificador);

}

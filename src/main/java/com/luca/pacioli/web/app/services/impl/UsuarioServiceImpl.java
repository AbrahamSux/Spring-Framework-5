package com.luca.pacioli.web.app.services.impl;

import com.luca.pacioli.web.app.models.Usuario;
import com.luca.pacioli.web.app.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService {

    private final List<Usuario> lista;

    public UsuarioServiceImpl() {
        this.lista = Arrays.asList(
                new Usuario(1, "Diana", "Camarillo"),
                new Usuario(2, "Yelena", "Belova"),
                new Usuario(3, "Denisse", "Guerrero")
        );
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return this.lista;
    }

    @Override
    public Usuario obtenerPorId(Integer identificador) {

        if (this.lista == null || this.lista.size() <= 0 ) {
            return null;
        }

        for(Usuario usuario : this.lista) {
            if (usuario.getId().equals(identificador)) {
                return usuario;
            }
        }

        return null;
    }

}

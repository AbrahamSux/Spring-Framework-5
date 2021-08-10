package com.luca.pacioli.web.app.controllers;

import com.luca.pacioli.web.app.errors.UsuarioException;
import com.luca.pacioli.web.app.models.Usuario;
import com.luca.pacioli.web.app.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController {

    @Autowired
    @Qualifier("usuarioServiceImpl")
    private UsuarioService usuarioService;



    @GetMapping({"/", "/index"})
    public String index() {

        // ERRORES Arithmetic.
        int value = 100/0;

        // ERRORES NumberFormat
        //int value = Integer.parseInt("10x");

        return "index";
    }

    @GetMapping("/ver/{id}")
    public String verUsuario(@PathVariable(name = "id") Integer indentificador, Model model) {

        /*Usuario usuario = usuarioService.obtenerPorId(indentificador);

        if (usuario == null) {
            throw new UsuarioException(indentificador.toString());
        }*/
        Usuario usuario = usuarioService.obtenerPorIdOptional(indentificador).orElseThrow(() ->
                new UsuarioException(indentificador.toString())
        );


        model.addAttribute("titulo", "Detalle del usuario : ".concat(usuario.getNombre()));
        model.addAttribute("user", usuario);

        return "ver";
    }

}

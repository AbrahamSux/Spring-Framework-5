package com.luca.pacioli.web.app.controllers;

import com.luca.pacioli.web.app.models.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FormController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormController.class);

    @GetMapping("/form")
    public String obtenerForm(Model model) {
        LOGGER.info(">>> obtenerForm() ");

        model.addAttribute("formulario", "Formulario del Usuario");

        //TODO: "siempre el manda el nombre de la Clase", esto para la vista que valida que no sea null, entonces,
        // mandamos una instancia del usuario para inicializar el objeto.
        model.addAttribute("usuario", new Usuario());

        return "form";
    }

    @PostMapping("/form")
    public String procesarForm(@Valid Usuario usuario, BindingResult result, Model model) {
        LOGGER.info(">>> procesarForm( " + usuario.toString() + " ) ");

        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();

            /**
             * ITERAMOS {@link result} PARA OBTENER CADA UNO DE LOS ERRORES.
             */
            result.getFieldErrors().forEach(fieldError -> {
                errores.put(
                        fieldError.getField(),
                        "El campo ".concat(fieldError.getField()).concat(" ").concat(fieldError.getDefaultMessage())
                );
            });

            // Retornamos a la misma vista del formulario para ver en que campo (s) esta el error.
            model.addAttribute("error", errores);
            return "form";
        }

        model.addAttribute("titulo", "Datos del Usuario");
        model.addAttribute("user", usuario);

        return "resultado";
    }

}

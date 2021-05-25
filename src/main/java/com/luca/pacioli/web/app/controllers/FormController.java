package com.luca.pacioli.web.app.controllers;

import com.luca.pacioli.web.app.models.entity.Usuario;
import com.luca.pacioli.web.app.validations.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@SessionAttributes("usuario")
public class FormController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormController.class);

    @Value("${controller.form.titulo.formulario}")
    private String tituloFormulario;

    @Value("${controller.form.titulo.user}")
    private String tituloUsuario;

    @Autowired
    @Qualifier("userValidator")
    private UserValidator userValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }

    @GetMapping("/form")
    public String obtenerForm(Model model) {
        LOGGER.info(">>> obtenerForm() ");

        Usuario usuario = new Usuario();
        usuario.setIdentificador("123-456-789-KH");
        usuario.setNombre("Ernesto");
        usuario.setApellido("Juárez");

        model.addAttribute("formulario", tituloFormulario);

        //TODO: "siempre el manda el nombre de la Clase", esto para la vista que valida que no sea null, entonces,
        // mandamos una instancia del usuario para inicializar el objeto.
        model.addAttribute("usuario", usuario);

        return "form";
    }

    @PostMapping("/form")
    public String procesarForm(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
        LOGGER.info(">>> procesarForm( " + usuario.toString() + " ) ");

        if (result.hasErrors()) {
            LOGGER.info("Retornando a la vista del form...");

            return "form";
        }

        model.addAttribute("titulo", tituloUsuario);
        model.addAttribute("user", usuario);
        status.setComplete();

        return "resultado";
    }

}

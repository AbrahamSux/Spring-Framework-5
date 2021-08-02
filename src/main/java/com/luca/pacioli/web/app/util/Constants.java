package com.luca.pacioli.web.app.util;

import com.luca.pacioli.web.app.models.entity.Pais;

import java.util.Arrays;
import java.util.List;

public final class Constants {

    public final static List<Pais> listaPaises = Arrays.asList(
            new Pais(1, "ES", "España"),
            new Pais(2, "MX", "México"),
            new Pais(3, "PE", "Perú"),
            new Pais(4, "CO", "Colombia"),
            new Pais(5, "CL", "Chile"),
            new Pais(6, "AR", "Argentina"),
            new Pais(7, "VE", "Venezuela")
    );

}

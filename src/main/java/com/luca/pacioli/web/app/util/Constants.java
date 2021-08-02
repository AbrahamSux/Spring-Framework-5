package com.luca.pacioli.web.app.util;

import com.luca.pacioli.web.app.models.entity.Pais;

import java.util.*;

public final class Constants {

    public final static List<String> paises = Arrays.asList(
            "España", "México", "Perú", "Colombia", "Chile", "Argentina", "Venezuela"
    );

    public final static Map<String, String> paisesMap() {
        Map<String, String> paises = new HashMap<String, String>();

        paises.put("ES", "España");
        paises.put("MX", "México");
        paises.put("CL", "Chile");
        paises.put("AR", "Argentina");
        paises.put("PE", "Perú");
        paises.put("CO", "Colombia");
        paises.put("VE", "Venezuela");

        return paises;
    }

    public final static List<Pais> listaPaises = Arrays.asList(
            new Pais(1, "ES", "España"),
            new Pais(2, "MX", "México"),
            new Pais(3, "PE", "Perú"),
            new Pais(4, "CO", "Colombia"),
            new Pais(5, "CL", "Chile"),
            new Pais(6, "AR", "Argentina"),
            new Pais(7, "VE", "Venezuela")
    );

    public final static List<String> listaRoles() {
        List<String> roles = new ArrayList<>();

        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        roles.add("ROLE_MODERATOR");

        return roles;
    }

}

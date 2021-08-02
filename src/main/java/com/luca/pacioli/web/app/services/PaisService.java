package com.luca.pacioli.web.app.services;

import com.luca.pacioli.web.app.models.entity.Pais;

import java.util.List;

public interface PaisService {

    List<Pais> obtenerPaises();

    Pais obtenerPaisPorId(Integer identificador);

}

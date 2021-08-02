package com.luca.pacioli.web.app.services.impl;

import com.luca.pacioli.web.app.models.entity.Pais;
import com.luca.pacioli.web.app.services.PaisService;
import com.luca.pacioli.web.app.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("paisService")
public class PaisServiceImpl implements PaisService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaisServiceImpl.class);

    private final List<Pais> listaPaises = Constants.listaPaises;


    @Override
    public List<Pais> obtenerPaises() {
        LOGGER.info(">>> obtenerPaises()");

        return this.listaPaises;
    }

    @Override
    public Pais obtenerPaisPorId(Integer identificador) {
        LOGGER.info(">>> obtenerPaisPorId( {} )", identificador);

        if (this.listaPaises == null || this.listaPaises.size() <= 0 ) {
            LOGGER.warn("Advertencia, la lista de paises es nulla o vacia.");

            return null;
        }

        for(Pais pais : this.listaPaises) {
            if (pais.getId().equals(identificador)) {
                return pais;
            }
        }
        LOGGER.info("No se encontro un pais con el identificador : {}", identificador);

        return null;
    }

}

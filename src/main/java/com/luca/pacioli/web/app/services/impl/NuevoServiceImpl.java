package com.luca.pacioli.web.app.services.impl;

import com.luca.pacioli.web.app.services.NuevoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description Clase que Implementa la lógica del Servicio {@link NuevoService} utilizada para el acceso a datos.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 19/05/2021 12:55:00 hrs.
 * @version 0.1
 */
public class NuevoServiceImpl implements NuevoService {

    /**
     * Utilizada para manipular los mensajes informativos y de error.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(NuevoServiceImpl.class);



    // METODOS

    @Override
    public String otherMessage() {
        LOGGER.info(">>> otherMessage() ");

        return "Mensaje enviado desde el metodo otherMessage() de NuevoServiceImpl...";
    }

}

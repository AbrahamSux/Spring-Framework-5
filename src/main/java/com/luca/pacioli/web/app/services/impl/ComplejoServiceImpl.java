/*
 * Proyecto:        Facturación - WebApp del Sistema de Facturación
 * Abraham Juárez S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.luca.pacioli.web.app.services.impl;

import com.luca.pacioli.web.app.services.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @description Clase que Implementa la lógica del Servicio {@link IndexService} utilizada para el acceso a datos.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 19/05/2021 12:17:00 hrs.
 * @version 0.2
 */
@Service("complejoService")
@Primary
public class ComplejoServiceImpl implements IndexService {

    /**
     * Utilizada para manipular los mensajes informativos y de error.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ComplejoServiceImpl.class);



    // METODOS

    @Override
    public String testMessage() {
        LOGGER.info(">>> testMessage() ");

        return "Mensaje enviado desde el metodo testMessage() de ComplejoServiceImpl...";
    }

    @Override
    public String testMessage(String text) {
        LOGGER.info(">>> testMessage( " + text + " ) ");

        return text.concat(" desde el metodo testMessage() de ComplejoServiceImpl...");
    }

}
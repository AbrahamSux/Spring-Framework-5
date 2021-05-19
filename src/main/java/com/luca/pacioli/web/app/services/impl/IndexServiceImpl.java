/*
 * Proyecto:        Facturación - WebApp del Sistema de Facturación
 * Abraham Juárez S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.luca.pacioli.web.app.services.impl;

import com.luca.pacioli.web.app.services.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @description Clase que Implementa la lógica del Servicio {@link IndexService} utilizada para el acceso a datos.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 19/05/2021 10:23:00 hrs.
 * @version 0.1
 */
@Service
public class IndexServiceImpl implements IndexService {

    /**
     * Utilizada para manipular los mensajes informativos y de error.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexServiceImpl.class);



    // METODOS

    @Override
    public String testMessage() {
        LOGGER.info(">>> test() ");

        return "Mensaje enviado desde el metodo test() de IndexService...";
    }

}

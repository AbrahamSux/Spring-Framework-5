package com.luca.pacioli.web.app.util.editors;

import com.luca.pacioli.web.app.models.entity.Pais;
import com.luca.pacioli.web.app.services.PaisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component("paisEditor")
public class PaisEditor extends PropertyEditorSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaisEditor.class);

    @Autowired
    @Qualifier("paisService")
    private PaisService paisService;

    @Override
    public void setAsText(String identificador) throws IllegalArgumentException {
        LOGGER.info("setAsText( {} )", identificador);

        Pais pais = null;
        try {
            Integer id = Integer.parseInt(identificador);
            pais = paisService.obtenerPaisPorId(id);
        } catch (NumberFormatException nfe) {
            this.setValue(null);
        }
        LOGGER.info("Pais : {}", ((pais != null) ? pais.toString() : "NULL") );

        this.setValue(pais);
    }

}

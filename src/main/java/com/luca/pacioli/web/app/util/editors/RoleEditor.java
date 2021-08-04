package com.luca.pacioli.web.app.util.editors;

import com.luca.pacioli.web.app.models.entity.Role;
import com.luca.pacioli.web.app.services.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component("roleEditor")
public class RoleEditor extends PropertyEditorSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleEditor.class);


    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;


    @Override
    public void setAsText(String identificador) throws IllegalArgumentException {
        LOGGER.info("setAsText( {} )", identificador);

        Role role = null;
        try {
            Integer id = Integer.parseInt(identificador);

            role = roleService.obtenerRolePorId(id);
        } catch (NumberFormatException nfe) {
            this.setValue(null);
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Role : {}", ((role != null) ? role.toString() : "NULL") );
        }

        this.setValue(role);
    }
}

package com.luca.pacioli.web.app.services.impl;

import com.luca.pacioli.web.app.models.entity.Role;
import com.luca.pacioli.web.app.services.RoleService;
import com.luca.pacioli.web.app.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

    private final List<Role> roles = Constants.listaDeRoles;


    @Override
    public List<Role> obtenerRoles() {
        LOGGER.info(">>> obtenerRoles()");

        return this.roles;
    }

    @Override
    public Role obtenerRolePorId(Integer identificador) {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("obtenerRolePorId( {} )", identificador);
        }

        if (this.roles == null || this.roles.size() <= 0 ) {
            LOGGER.warn("Advertencia, la lista de roles es nulla o vacia.");

            return null;
        }

        for(Role role : this.roles) {
            if (role.getId().equals(identificador)) {
                return role;
            }
        }
        LOGGER.info("No se encontro un Role con el identificador : {}", identificador);

        return null;
    }

}

package com.luca.pacioli.web.app.services;

import com.luca.pacioli.web.app.models.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> obtenerRoles();

    Role obtenerRolePorId(Integer identificador);
}

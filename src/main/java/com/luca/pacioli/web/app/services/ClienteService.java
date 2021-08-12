package com.luca.pacioli.web.app.services;

import com.luca.pacioli.web.app.models.entity.Cliente;

import java.util.List;

public interface ClienteService {

    public List<Cliente> findAll();

    public void save(Cliente cliente);

}

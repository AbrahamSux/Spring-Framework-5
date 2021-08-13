package com.luca.pacioli.web.app.services.impl;

import com.luca.pacioli.web.app.models.entity.Cliente;
import com.luca.pacioli.web.app.repository.ClienteRepository;
import com.luca.pacioli.web.app.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("clienteServiceImpl")
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    @Qualifier("clienteRepositoryImpl")
    private ClienteRepository clienteRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {

        return clienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findOne(Long identificador) {

        return clienteRepository.findOne(identificador);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {

        clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long identificador) {

        clienteRepository.delete(identificador);
    }

}

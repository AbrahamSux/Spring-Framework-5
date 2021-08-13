package com.luca.pacioli.web.app.services.impl;

import com.luca.pacioli.web.app.models.entity.Cliente;
import com.luca.pacioli.web.app.dao.ClienteDao;
import com.luca.pacioli.web.app.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("clienteServiceImpl")
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    @Qualifier("clienteDaoImpl")
    private ClienteDao clienteDao;


    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {

        return clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findOne(Long identificador) {

        return clienteDao.findOne(identificador);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {

        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long identificador) {

        clienteDao.delete(identificador);
    }

}

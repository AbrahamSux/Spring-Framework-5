package com.luca.pacioli.web.app.services.impl;

import com.luca.pacioli.web.app.models.entity.Cliente;
import com.luca.pacioli.web.app.dao.ClienteDao;
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
    @Qualifier("clienteDaoImpl")
    private ClienteDao clienteDao;

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {

        // IMPLEMENTACIÓN USANDO 'DAO'
        // return clienteDao.findAll();

        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findOne(Long identificador) {

        // IMPLEMENTACIÓN USANDO 'DAO'
        // return clienteDao.findOne(identificador);

        return clienteRepository.findById(identificador).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {

        // IMPLEMENTACIÓN USANDO 'DAO'
        // clienteDao.save(cliente);

        clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long identificador) {

        // IMPLEMENTACIÓN USANDO 'DAO'
        // clienteDao.delete(identificador);

        clienteRepository.deleteById(identificador);
    }

}

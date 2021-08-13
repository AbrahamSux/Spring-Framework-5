package com.luca.pacioli.web.app.services.impl;

import com.luca.pacioli.web.app.models.entity.Cliente;
import com.luca.pacioli.web.app.services.ClienteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("clienteServiceImpl")
public class ClienteServiceImpl implements ClienteService {

    @PersistenceContext
    private EntityManager entityManager;



    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {

        return entityManager.createQuery("from Cliente").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findOne(Long identificador) {

        return entityManager.find(Cliente.class, identificador);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {

        // SI EL IDENTIFICADOR DEL CLIENTE NO ES NULO Y ES MAYOR A CERO, ENTONCES, ACTUALIZAMOS LOS DATOS.
        if (cliente.getId() != null && cliente.getId() > 0) {
            entityManager.merge(cliente);
        }
        else {
            // SE CREA/GUARDA UN NUEVO CLIENTE.
            entityManager.persist(cliente);
        }
    }

    @Override
    @Transactional
    public void delete(Long identificador) {
        Cliente cliente = null;

        if (identificador > 0) {
            cliente = findOne(identificador);
        }

        if (cliente != null) {
            entityManager.remove(cliente);
        }
    }

}

package com.luca.pacioli.web.app.repository.impl;

import com.luca.pacioli.web.app.models.entity.Cliente;
import com.luca.pacioli.web.app.repository.ClienteRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("clienteRepositoryImpl")
public class ClienteRepositoryImpl implements ClienteRepository {

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public List<Cliente> findAll() {

        return entityManager.createQuery("from Cliente").getResultList();
    }

    @Override
    public Cliente findOne(Long identificador) {

        return entityManager.find(Cliente.class, identificador);
    }

    @Override
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

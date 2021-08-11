package com.luca.pacioli.web.app.services.repository;

import com.luca.pacioli.web.app.models.entity.Cliente;
import com.luca.pacioli.web.app.services.ClienteService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("clienteRepository")
public class ClienteRepository implements ClienteService {

    @PersistenceContext
    private EntityManager entityManager;



    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return entityManager.createQuery("from Cliente").getResultList();
    }

}

package com.luca.pacioli.web.app.repository;

import com.luca.pacioli.web.app.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}

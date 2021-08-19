package com.luca.pacioli.web.app.repository;

import com.luca.pacioli.web.app.models.entity.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {
}

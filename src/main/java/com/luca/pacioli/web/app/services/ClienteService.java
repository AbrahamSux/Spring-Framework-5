package com.luca.pacioli.web.app.services;

import com.luca.pacioli.web.app.models.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService {

    /**
     * Método encargado de regresar una lista de todos los clientes.
     *
     * @return Lista de todos los cientes.
     */
    public List<Cliente> findAll();

    /**
     * Método encargado de ir a buscar el cliente correspondiente al identificador recibido.
     *
     * @param identificador Identificador del cliente.
     * @return El cliente correspondiente al identificador.
     */
    public Cliente findOne(Long identificador);

    /**
     * Método encargado de ir a guardar/editar el cliente recibido.
     *
     * @param cliente Cliente a editar/guardar.
     */
    public void save(Cliente cliente);

    /**
     * Método encargado de ir a eliminar el cliente correspondiente al identificador recibido.
     *
     * @param identificador Identificador del cliente.
     */
    public void delete(Long identificador);

    public Page<Cliente> findAll(Pageable pageable);

}

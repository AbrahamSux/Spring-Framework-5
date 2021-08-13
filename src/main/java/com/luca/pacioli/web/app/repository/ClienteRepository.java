package com.luca.pacioli.web.app.repository;

import com.luca.pacioli.web.app.models.entity.Cliente;

import java.util.List;

public interface ClienteRepository {

    /**
     * Método encargado de consultar la lista con todos los clientes.
     *
     * @return Lista de todos los cientes.
     */
    public List<Cliente> findAll();

    /**
     * Método encargado de buscar el cliente correspondiente al identificador recibido.
     *
     * @param identificador Identificador del cliente.
     * @return El cliente correspondiente al identificador.
     */
    public Cliente findOne(Long identificador);

    /**
     * Método encargado de guardar/editar el cliente recibido.
     *
     * @param cliente Cliente a editar/guardar.
     */
    public void save(Cliente cliente);

    /**
     * Método encargado de eliminar el cliente correspondiente al identificador recibido.
     *
     * @param identificador Identificador del cliente.
     */
    public void delete(Long identificador);

}

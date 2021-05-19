/*
 * Proyecto:        Facturación - WebApp del Sistema de Facturación
 * Abraham Juárez S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.luca.pacioli.web.app.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description Clase Componente para hacer referencia a la Factura.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 19/05/2021 14:24:00 hrs.
 * @version 0.1
 */
@Component
public class Factura {

    @Value("${factura.decripcion}")
    private String descripcion;

    @Autowired
    private Cliente cliente;

    @Autowired
    @Qualifier("itemsFacturaLenovo")
    private List<ItemFactura> items;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItems() {
        return items;
    }

    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "descripcion='" + descripcion + '\'' +
                ", cliente=" + cliente +
                ", items=" + items +
                '}';
    }

}

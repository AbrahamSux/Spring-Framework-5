/*
 * Proyecto:        Facturación - WebApp del Sistema de Facturación
 * Abraham Juárez S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.luca.pacioli.web.app.models;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description Clase Item para hacer referencia a un Producto.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 19/05/2021 14:26:00 hrs.
 * @version 0.1
 */
public class ItemFactura {

    private Producto producto;

    private Integer cantidad;

    public ItemFactura(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ItemFactura{" +
                "producto=" + producto +
                ", cantidad=" + cantidad +
                '}';
    }

}

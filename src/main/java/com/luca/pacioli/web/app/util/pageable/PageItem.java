package com.luca.pacioli.web.app.util.pageable;

public class PageItem {

    private int numeroPagina;

    private boolean isActual;

    public PageItem(int numeroPagina, boolean isActual) {
        this.numeroPagina = numeroPagina;
        this.isActual = isActual;
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public boolean isActual() {
        return isActual;
    }

}

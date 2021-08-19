package com.luca.pacioli.web.app.util.pageable;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PageRender<T> {

    private String url;

    private Page<T> page;

    private int totalPaginas;

    /**
     * @param numElementosPorPagina
     *
     * Establece la cantidad de páginas que se mostraran en la nav-bar, es decir, actualmente solo se muestran
     * 5 páginas, pero pueden ser 10, 15, etc.
     */
    private int numElementosPorPagina;

    private int paginaActual;

    private List<PageItem> paginas;

    public PageRender(String url, Page<T> page) {
        this.url = url;
        this.page = page;
        this.paginas = new ArrayList<PageItem>();

        totalPaginas = page.getTotalPages();
        numElementosPorPagina = page.getSize();
        paginaActual = page.getNumber() + 1;

        int desde, hasta;

        // PARA CUANDO EL TOTAL DE PÁGINAS, ES MENOR O IGUAL QUE, EL NÚMERO DE ELEMENTOS POR PÁGINA.
        if (totalPaginas <= numElementosPorPagina) {
            desde = 1;
            hasta = totalPaginas;
        }
        else {
            // PARA MOSTRAR RANGO INICIAL (PÁGINAS PRIMERA Y SEGUNDA).
            if (paginaActual <= numElementosPorPagina / 2) {
                desde = 1;
                hasta = numElementosPorPagina;
            }
            // PARA MOSTRAR RANGO FINAL (PÁGINAS PENÚLTIMA Y ÚLTIMA).
            else if(paginaActual >= (totalPaginas - numElementosPorPagina / 2)) {
                desde = totalPaginas - numElementosPorPagina + 1;
                hasta = numElementosPorPagina;
            }
            // PARA LOS RANGOS INTERMEDIOS.
            else {
                desde = paginaActual - (numElementosPorPagina / 2);
                hasta = numElementosPorPagina;
            }
        }

        // RANGO DE PÁGINAS QUE SE MOSTRARÁN EN LA VISTA.
        for (int i = 0; i < hasta; i++) {
            paginas.add(new PageItem(desde + i, paginaActual == desde + i));
        }
    }

    public String getUrl() {
        return url;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public int getPaginaActual() {
        return paginaActual;
    }

    public List<PageItem> getPaginas() {
        return paginas;
    }

    public boolean isFirst() {
        return page.isFirst();
    }

    public boolean isLast() {
        return page.isLast();
    }

    public boolean isHasNext() {
        return page.hasNext();
    }

    public boolean isHasPrevious() {
        return page.hasPrevious();
    }

}

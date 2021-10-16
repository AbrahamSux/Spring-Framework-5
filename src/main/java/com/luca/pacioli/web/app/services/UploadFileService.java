package com.luca.pacioli.web.app.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

public interface UploadFileService {

    /**
     * Método encargado de cargar/obtener la foto.
     *
     * @param filename Nombre del archivo/foto.
     * @return El recurso obtenido.
     * @throws MalformedURLException Si ocurre un error al momento de obtener el recurso.
     */
    public Resource loadFile(String filename) throws MalformedURLException;

    /**
     * Método encargado de copiar el archivo en el directorio.
     *
     * @param file Archivo a copiar.
     * @return El nombre del archivo copiado.
     * @throws IOException Si ocurre un error al momento de copiar el archivo.
     */
    public String copyFile(MultipartFile file) throws IOException;

    /**
     * Método encargado de eliminar el archivo.
     *
     * @param filename Archivo a eliminar.
     * @return TRUE si el archivo se elimina correctamente, FALSE en caso contrario.
     */
    public boolean deleteFile(String filename);

}

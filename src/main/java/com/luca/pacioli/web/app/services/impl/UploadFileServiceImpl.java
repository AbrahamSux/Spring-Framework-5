package com.luca.pacioli.web.app.services.impl;

import com.luca.pacioli.web.app.services.UploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@Service("uploadFileServiceImpl")
public class UploadFileServiceImpl implements UploadFileService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UploadFileServiceImpl.class);



    // MÉTODOS

    @Override
    public Resource loadFile(String filename) throws MalformedURLException {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> loadFile( {} )", filename);
        }

        Resource resource = null;
        Path pathFoto = getPath(filename);

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("> pathFoto: {}", pathFoto);
        }

        resource = new UrlResource(pathFoto.toUri());
        if (!resource.exists() || !resource.isReadable()) {
            throw new RuntimeException("Fallo al momento de cargar el archivo: " + pathFoto.toString());
        }

        return resource;
    }

    @Override
    public String copyFile(MultipartFile file) throws IOException {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> copyFile( {} )", file);
        }

        String uniqueFileName;

        try {
            uniqueFileName = UUID.randomUUID().toString().concat("_").concat(Objects.requireNonNull(file.getOriginalFilename()));

            // OBTENEMOS LA RUTA DEL DIRECTORIO DE RECURSOS.
            Path rootPath = getPath(uniqueFileName);

            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("> rootPath ( {} )", rootPath);
            }

            // CREAMOS Y ESCRIBIMOS LA IMAGEN/ARCHIVO.
            Files.copy(file.getInputStream(), rootPath);

        } catch (IOException e) {
            e.printStackTrace();

            throw new IOException(e.getMessage());
        }

        return uniqueFileName;
    }

    @Override
    public boolean deleteFile(String filename) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> deleteFile( {} )", filename);
        }

        Path rootPath = getPath(filename);
        File archivo = rootPath.toFile();

        // SE ELIMINA EL ARCHIVO.
        if (archivo.exists() && archivo.canRead()) {
            return archivo.delete();
        }

        return false;
    }



    // MÉTODOS PRIVADOS

    private Path getPath(String filename) {

        return Paths.get("uploads").resolve(filename).toAbsolutePath();
    }

}

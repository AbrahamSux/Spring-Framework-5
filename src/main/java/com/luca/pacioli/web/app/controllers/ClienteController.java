package com.luca.pacioli.web.app.controllers;

import com.luca.pacioli.web.app.models.entity.Cliente;
import com.luca.pacioli.web.app.services.ClienteService;
import com.luca.pacioli.web.app.services.UploadFileService;
import com.luca.pacioli.web.app.util.pageable.PageRender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.Objects;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);


    @Autowired
    @Qualifier("clienteServiceImpl")
    private ClienteService clienteService;

    @Autowired
    @Qualifier("uploadFileServiceImpl")
    private UploadFileService uploadFileService;


    /**
     * Constantes.
     */
    private static final String TITULO = "titulo";
    private static final String CLIENTE = "cliente";
    private static final String DANGER = "danger";



    /**
     * Método encargado de mostrar todos los clientes.
     *
     * @param model Modelo para pasar los datos a la vista.
     * @return Retorna la vista 'mostrar'.
     */
    @RequestMapping(value = {"/clientes", "/"}, method = RequestMethod.GET)
    public String listarClientes(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> listarClientes( {} )", page);
        }

        // SE ESTABLECE EL TAMAÑO DE ELEMENTOS POR PAGE.
        Pageable pageRequest = PageRequest.of(page, 5);

        // RE SERALIZA LA CONSULTA DE ELEMENTOS.
        Page<Cliente> clientesPage = clienteService.findAll(pageRequest);

        // PAGINADOR PARA LA VISTA.
        PageRender pageRender = new PageRender("/clientes", clientesPage);

        model.addAttribute(TITULO, "Listado de clientes");
        model.addAttribute("clientes", clientesPage);
        model.addAttribute("pageRender", pageRender);

        return "mostrar";
    }

    /**
     * Método encargado de cargar el formulario.
     *
     * @param model Modelo para pasar los datos a la vista.
     * @return Retorna la vista 'form'.
     */
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String cargarFormularioCliente(Map<String, Object> model) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> cargarFormularioCliente()");
        }

        model.put(TITULO, "Formulario del cliente");
        model.put(CLIENTE, new Cliente());

        return "form";
    }

    /**
     * Método encargado de guardar los datos mandados a través del fomulario.
     *
     * @param cliente Cliente a guardar.
     * @param result Contiene el resultado de la validación y el enlace y contiene errores que pueden haber ocurrido.
     * @param model Modelo para pasar los datos a la vista.
     * @param foto Archivo multimedia cargado en el formulario.
     * @param flash Almacena atributos flash y se propagarán automáticamente a la "salida" FlashMap de la solicitud actual.
     * @param status Estatus de la sesión.
     * @return Redirecciona a la vista 'clientes'.
     */
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardarCliente(@Valid Cliente cliente, BindingResult result, Model model, @RequestParam("file") MultipartFile foto,
                                 RedirectAttributes flash, SessionStatus status) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> guardarCliente( {} )", cliente.toString() );
        }

        if (result.hasErrors()) {
            model.addAttribute(TITULO, "Formulario del cliente");

            return "form";
        }

        if (cliente.getId() != null && cliente.getId() > 0 && cliente.getFoto() != null &&  cliente.getFoto().length() > 0) {
            boolean deleteFile =  uploadFileService.deleteFile(cliente.getFoto());

            LOGGER.info("> deleteFile : {}", deleteFile);
        }

        if (!foto.isEmpty()) {
            try {
                String uniqueFileName = uploadFileService.copyFile(foto);

                // Flash Messenger
                // Un FlashMap se guarda antes de la redirección (normalmente en la sesión) y está disponible después
                // de la redirección y se elimina inmediatamente.
                flash.addFlashAttribute("info", "La imagen { " + uniqueFileName + " } se ha subido correctamente!");

                cliente.setFoto(uniqueFileName);
            } catch (IOException e) {
                flash.addFlashAttribute(DANGER, "Falló al momento de cargar el archivo!");
                e.printStackTrace();
            }
        }

        String messageFlash = ((cliente.getId() == null)? "Cliente creado existosamente!" : "Cliente editado existosamente!");

        clienteService.save(cliente);

        // SE COMPLETA EL PROCESAMIENTO DE LA SESIÓN, LO QUE PERMITE LA LIMPIEZA DE LOS ATRIBUTOS DE LA SESIÓN.
        status.setComplete();

        // Flash Messenger
        flash.addFlashAttribute("success", messageFlash);

        return "redirect:/clientes";
    }

    /**
     * Método encargado de mandar al formulario el cliente a editar correspondiente al identificador recibido.
     *
     * @param identificador Identificador del cliente.
     * @param modelMap Modelo para pasar los datos a la vista.
     * @param flash Almacena atributos flash y se propagarán automáticamente a la "salida" FlashMap de la solicitud actual.
     * @return Retorna la vista 'form'.
     */
    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public String editarCliente(@PathVariable(value = "id") Long identificador, ModelMap modelMap, RedirectAttributes flash) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> editarCliente( {} )", identificador );
        }

        Cliente cliente = null;

        if (identificador <= 0) {
            flash.addFlashAttribute(DANGER, "El identificador no es válido, ID : " + identificador);

            return "redirect:/clientes";
        }

        cliente = clienteService.findOne(identificador);

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Cliente a Editar : {}", ((cliente != null) ? cliente.toString() : "NULL") );
        }

        if (cliente != null) {
            modelMap.addAttribute(TITULO, "Editar cliente");
            modelMap.addAttribute(CLIENTE, cliente);
        } else {
            flash.addFlashAttribute(DANGER, "Falló al momento de buscar al cliente con ID : " + identificador);

            return "redirect:/clientes";
        }

        return "form";
    }

    /**
     * Método encargado de eliminar el cliente correspondiente al identificador recibido.
     *
     * @param identificador Identificador del cliente.
     * @param flash Almacena atributos flash y se propagarán automáticamente a la "salida" FlashMap de la solicitud actual.
     * @return Redirecciona a la vista 'clientes'.
     */
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
    public String eliminarCliente(@PathVariable(value = "id") Long identificador, RedirectAttributes flash) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> eliminarCliente( {} )", identificador );
        }

        if (identificador <= 0) {
            return "redirect:/clientes";
        }

        // RECUPERAMOS EL CLIENTE ANTES DE ELIMINARLO.
        Cliente cliente = clienteService.findOne(identificador);

        boolean deleteFile = uploadFileService.deleteFile(cliente.getFoto());

        // SE ELIMINA EL CLIENTE.
        clienteService.delete(identificador);

        // Flash Messenger
        flash.addFlashAttribute("success", "Cliente eliminado existosamente!");

        // SE ELIMINA EL ARCHIVO.
        if(deleteFile) {
            flash.addFlashAttribute("info", "Foto '" + cliente.getFoto() + "' eliminada correctamente.");
        } else {
            flash.addFlashAttribute(DANGER, "Falló al momento de eliminar la foto: " + cliente.getFoto());
        }

        return "redirect:/clientes";
    }

    /**
     * Método encargado de mostrar el cliente correspondiente al identificador recibido.
     *
     * @param identificador Identificador del Cliente.
     * @param model Modelo para pasar los datos a la vista.
     * @param flash Almacena atributos flash y se propagarán automáticamente a la "salida" FlashMap de la solicitud actual.
     * @return Retorna la vista 'mostrarCliente'.
     */
    @RequestMapping(value = "/mostrarCliente/{id}", method = RequestMethod.GET)
    public String mostrarCliente(@PathVariable(value = "id") Long identificador, Map<String, Object> model,
                                 RedirectAttributes flash) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> mostrarCliente( {} )", identificador);
        }

        Cliente cliente = clienteService.findOne(identificador);

        if (cliente == null) {
            flash.addFlashAttribute(DANGER, "El cliente no existe en la base de datos!");
            return "redirect:/clientes";
        }

        String nameClient = cliente.getNombre()
                            .concat(" ").concat(cliente.getApellidoPaterno())
                            .concat(" ").concat(cliente.getApellidoMaterno());

        model.put(CLIENTE, cliente);
        model.put(TITULO, "Detalle del cliente: " + nameClient);

        return "mostrarCliente";
    }

    /**
     * Método encargado de obtener la foto correspondiente al cliente a mostrar.
     *
     * @param foto Foto del Cliente a mostrar.
     * @return La ruta del recurso (Foto).
     */
    @RequestMapping(value = "/uploads/{filename:.+}", method = RequestMethod.GET)
    public ResponseEntity<Resource> obtenerFoto(@PathVariable(value = "filename") String foto) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> obtenerFoto( {} )", foto);
        }

        Resource resource = null;
        try {
            resource = uploadFileService.loadFile(foto);
        } catch (MalformedURLException e) {
            e.printStackTrace();

            throw new RuntimeException("Fallo al momento de cargar el archivo: " + foto);
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + Objects.requireNonNull(resource).getFilename() +"\"")
                .body(resource);
    }

}

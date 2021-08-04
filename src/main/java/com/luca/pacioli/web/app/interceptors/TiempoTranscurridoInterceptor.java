package com.luca.pacioli.web.app.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@Component("tiempoTranscurridoInterceptor")
public class TiempoTranscurridoInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        LOGGER.info(">>> Entrando : preHandle()");

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            LOGGER.info("Es un metodo del Controlador : {} => {}", handlerMethod.getBeanType(), handlerMethod.getMethod().getName());
        }

        LOGGER.info("Interceptando en preHandle : {}", handler);

        long tiempoInicio = System.currentTimeMillis();

        request.setAttribute("tiempoInicio", tiempoInicio);

        // REALIZA TIEMPO MUERTO.
        Random random = new Random();
        Integer demora = random.nextInt(500);
        Thread.sleep(demora);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        LOGGER.info(">>> Saliendo : postHandle()");

        LOGGER.info("Interceptando en postHandle : {}", handler);

        long tiempoFin = System.currentTimeMillis();

        long tiempoInicio = (long) request.getAttribute("tiempoInicio");
        long tiempoTranscurrido = tiempoFin - tiempoInicio;

        if (handler instanceof HandlerMethod && modelAndView != null) {
            modelAndView.addObject("tiempoTranscurrido", tiempoTranscurrido);
        }

        LOGGER.info("Tiempo Transcurrido : {} en milisegundos", tiempoTranscurrido);
    }
}

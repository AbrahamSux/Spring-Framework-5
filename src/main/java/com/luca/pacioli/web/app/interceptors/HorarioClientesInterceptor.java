package com.luca.pacioli.web.app.interceptors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

@Component("horarioClientesInterceptor")
public class HorarioClientesInterceptor implements HandlerInterceptor {

    @Value("${config.horario.apertura}")
    private Integer valueApertura;

    @Value("${config.horario.cierre}")
    private Integer valueCierre;



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        System.out.println(">>> preHandle() ");

        Calendar calendar = Calendar.getInstance();
        int horaActual = calendar.get(Calendar.HOUR_OF_DAY);

        System.out.println("HORA ACTUAL DEL SISTEMA: " + horaActual);

        // SI LA HORA ACTUAL ESTA DENTRO DEL HORARIO DE ATENCIÓN A CLIENTES.
        if (horaActual >= valueApertura && horaActual < valueCierre) {
            StringBuilder mensaje = new StringBuilder("Bienvenidos al horario de atención a clientes");
            mensaje.append(", atendemos desde las ");
            mensaje.append(valueApertura);
            mensaje.append(" hrs. hasta las ");
            mensaje.append(valueCierre);
            mensaje.append(" hrs. Gracias por su visita.");

            request.setAttribute("preMensaje", mensaje.toString());

            return true;
        }

        response.sendRedirect(request.getContextPath().concat("/app/saliendo"));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {

        System.out.println(">>> postHandle() ");

        String mensaje = (String) request.getAttribute("preMensaje");

        if (modelAndView != null && handler instanceof HandlerMethod) {
            modelAndView.addObject("postMensaje", mensaje);
        }
    }

}

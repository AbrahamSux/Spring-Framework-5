package com.luca.pacioli.web.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(ArithmeticException.class)
    public String errorArithmetic(ArithmeticException e, Model model) {

        model.addAttribute("error", "Se ha producido un error Aritmético!");
        model.addAttribute("message", e.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        model.addAttribute("trace", e.fillInStackTrace());

        //return "error/aritmetica";

        return "error/templateGeneric";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String errorNumberFormat(NumberFormatException e, Model model) {

        model.addAttribute("error", "Se ha producido un error de Formato Numérico!");
        model.addAttribute("message", e.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        model.addAttribute("trace", e.fillInStackTrace());

        //return "error/numberFormat";

        return "error/templateGeneric";
    }

}

package com.example.demo.exception;

import java.util.Map;

public class ErrorResponse {

    private String mensaje;
    private Map<String, String> errores;

    public ErrorResponse() {
    }

    public ErrorResponse(String mensaje, Map<String, String> errores) {
        this.mensaje = mensaje;
        this.errores = errores;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Map<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }
}
package com.example.demo.handler.exceptions;

public class UsuarioExistente extends RuntimeException{

    public UsuarioExistente(String message) {
        super(message);
    }

    public UsuarioExistente(String message, Throwable cause) {
        super(message, cause);
    }
}

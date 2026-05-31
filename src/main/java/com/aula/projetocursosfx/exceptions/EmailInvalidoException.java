package com.aula.projetocursosfx.exceptions;

public class EmailInvalidoException extends RuntimeException {

    public EmailInvalidoException(String mensagem) {
        super(mensagem);
    }
}
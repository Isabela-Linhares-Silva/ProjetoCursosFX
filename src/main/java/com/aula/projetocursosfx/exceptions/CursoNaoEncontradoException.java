package com.aula.projetocursosfx.exceptions;

public class CursoNaoEncontradoException extends RuntimeException {

    public CursoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
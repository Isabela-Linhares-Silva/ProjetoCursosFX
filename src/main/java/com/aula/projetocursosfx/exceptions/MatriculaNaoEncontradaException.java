package com.aula.projetocursosfx.exceptions;

public class MatriculaNaoEncontradaException extends RuntimeException {

    public MatriculaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
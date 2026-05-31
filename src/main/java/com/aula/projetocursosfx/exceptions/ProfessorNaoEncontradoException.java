package com.aula.projetocursosfx.exceptions;

public class ProfessorNaoEncontradoException extends RuntimeException {

    public ProfessorNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
package com.aula.projetocursosfx.exceptions;

public class AlunoNaoEncontradoException extends RuntimeException {

    public AlunoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
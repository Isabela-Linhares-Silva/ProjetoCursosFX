package com.aula.projetocursosfx.model.dao;

import com.aula.projetocursosfx.exceptions.AlunoNaoEncontradoException;
import com.aula.projetocursosfx.model.entities.Aluno;

import java.util.List;

public interface AlunoDao {
    public void insert(Aluno obj);
    public void update(Aluno obj);
    public void deleteByID(Integer id);
    public Aluno findByID(Integer id) throws AlunoNaoEncontradoException;
    public List<Aluno> findAll();
}

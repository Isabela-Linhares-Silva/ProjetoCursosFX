package com.aula.projetocursosfx.model.dao;

import com.aula.projetocursosfx.exceptions.ProfessorNaoEncontradoException;
import com.aula.projetocursosfx.model.entities.Professor;

import java.util.List;

public interface ProfessorDao {
    public void insert(Professor obj);
    public void update(Professor obj);
    public void deleteByID(Integer id);
    public Professor findByID(Integer id) throws ProfessorNaoEncontradoException;
    public List<Professor> findAll();
}

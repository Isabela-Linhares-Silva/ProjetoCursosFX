package com.aula.projetocursosfx.model.dao;

import com.aula.projetocursosfx.exceptions.MatriculaNaoEncontradaException;
import com.aula.projetocursosfx.model.entities.Matricula;

import java.util.List;

public interface MatriculaDao {
    public void insert(Matricula obj);
    public void update(Matricula obj);
    public void deleteByID(Integer id);
    public Matricula findByID(Integer id) throws MatriculaNaoEncontradaException;
    public List<Matricula> findAll();
}

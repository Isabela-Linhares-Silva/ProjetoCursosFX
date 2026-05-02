package com.aula.projetocursosfx.model.dao;

import com.aula.projetocursosfx.model.entities.Curso;

import java.util.List;

public interface CursoDao {
    public void insert(Curso obj);
    public void update(Curso obj);
    public void deleteByID(Integer id);
    public Curso findByID(Integer id);
    public List<Curso> findAll();
}

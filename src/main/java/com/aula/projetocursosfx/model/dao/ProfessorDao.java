package com.aula.projetocursosfx.model.dao;

import com.aula.projetocursosfx.model.entities.Professor;

import java.util.List;

public interface ProfessorDao {
    public void insert(Professor obj);
    public void update(Professor obj);
    public void deleteByID(Integer id);
    public Professor findByID(Integer id);
    public List<Professor> findAll();
}

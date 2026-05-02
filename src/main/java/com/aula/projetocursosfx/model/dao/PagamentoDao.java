package com.aula.projetocursosfx.model.dao;

import com.aula.projetocursosfx.model.entities.Pagamento;

import java.util.List;

public interface PagamentoDao {
    public void insert(Pagamento obj);
    public void update(Pagamento obj);
    public void deleteByID(Integer id);
    public Pagamento findByID(Integer id);
    public List<Pagamento> findAll();
}

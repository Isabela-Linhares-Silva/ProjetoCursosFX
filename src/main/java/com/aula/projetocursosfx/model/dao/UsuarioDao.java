package com.aula.projetocursosfx.model.dao;

import com.aula.projetocursosfx.model.entities.Usuario;

public interface UsuarioDao {
    void insert(Usuario obj);

    Usuario autenticar(String email, String senha);
}

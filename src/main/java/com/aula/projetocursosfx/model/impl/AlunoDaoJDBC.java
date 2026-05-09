package com.aula.projetocursosfx.model.impl;

import com.aula.projetocursosfx.model.dao.AlunoDao;
import com.aula.projetocursosfx.model.entities.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AlunoDaoJDBC implements AlunoDao {
    private Connection connection;

    public AlunoDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    public void insert(Aluno obj){
        try {
            PreparedStatement st = connection.prepareStatement(
                    "INSERT INTO aluno (id, nome, email) VALUES (?, ?, ?)"
            );
            st.setInt(1, obj.getId());
            st.setString(2, obj.getNome());
            st.setString(3, obj.getEmail());
            st.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void update(Aluno obj) {
    }

    @Override
    public void deleteByID(Integer id) {
    }

    @Override
    public Aluno findByID(Integer id) {
        return null;
    }

    @Override
    public List<Aluno> findAll() {
        return null;
    }
}

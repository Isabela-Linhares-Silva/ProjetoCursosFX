package com.aula.projetocursosfx.model.dao.impl;

import com.aula.projetocursosfx.model.dao.UsuarioDao;
import com.aula.projetocursosfx.model.entities.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aula.projetocursosfx.db.DB;

public class UsuarioDaoJDBC implements UsuarioDao {

    private Connection connection;

    public UsuarioDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Usuario autenticar(String email, String senha) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = connection.prepareStatement(
                    "SELECT * FROM usuario WHERE email = ? AND senha = ?"
            );

            st.setString(1, email);
            st.setString(2, senha);

            rs = st.executeQuery();

            if (rs.next()) {

                Usuario usuario = new Usuario();

                usuario.setId(rs.getInt("id"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));

                return usuario;
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    @Override
    public void insert(Usuario obj) {

        PreparedStatement st = null;

        try {

            st = connection.prepareStatement(
                    "INSERT INTO usuario (email, senha) VALUES (?, ?)"
            );

            st.setString(1, obj.getEmail());
            st.setString(2, obj.getSenha());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(st);
        }
    }


}

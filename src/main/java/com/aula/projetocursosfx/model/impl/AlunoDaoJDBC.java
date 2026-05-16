package com.aula.projetocursosfx.model.impl;

import com.aula.projetocursosfx.db.DB;
import com.aula.projetocursosfx.model.dao.AlunoDao;
import com.aula.projetocursosfx.model.entities.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void update(Aluno obj) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(
                    "UPDATE aluno SET nome=?, email=? WHERE id=?"
            );

            st.setString(1, obj.getNome());
            st.setString(2, obj.getEmail());

            st.executeUpdate();

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteByID(Integer id) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(
                    "DELETE from aluno WHERE id=?"
            );

            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Aluno findByID(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = connection.prepareStatement("SELECT * FROM aluno WHERE id=?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()) {
                Aluno a = new Aluno(rs.getInt("id"), rs.getString("nome"), rs.getString("email"));
            }
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return null;
    }

    @Override
    public List<Aluno> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = connection.prepareStatement(
                    "SELECT  * FROM aluno"
            );

            rs = st.executeQuery();
            List<Aluno> lista = new ArrayList<>();

            while (rs.next()){
                lista.add(new Aluno(rs.getInt("id"), rs.getString("nome"), rs.getString("email")));
            }
            return lista;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }
}

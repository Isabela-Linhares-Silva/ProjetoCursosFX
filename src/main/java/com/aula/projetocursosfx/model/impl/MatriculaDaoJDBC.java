package com.aula.projetocursosfx.model.impl;

import com.aula.projetocursosfx.db.DB;
import com.aula.projetocursosfx.model.entities.Matricula;

import java.sql.*;
import java.util.List;

public class MatriculaDaoJDBC {
    private Connection connection;

    public MatriculaDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    public void insert(Matricula obj){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = connection.prepareStatement("insert into matricula(data, status, aluno, curso) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            st.setDate(1,obj.getData());
            st.setString(2,obj.getStatus());
            st.setInt(3,obj.getAluno().getId());
            st.setInt(4,obj.getCurso().getId());
            int linhas = st.executeUpdate();

            if (linhas != 0 ){
                rs = st.getGeneratedKeys();

                if (rs.next()){
                    obj.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }

    }

    public void update(Matricula obj){

    }

    public void deleteByID(Integer id){

    }

    public Matricula findByID(Integer id){

    }

    public List<Matricula> findAll(){

    }
}

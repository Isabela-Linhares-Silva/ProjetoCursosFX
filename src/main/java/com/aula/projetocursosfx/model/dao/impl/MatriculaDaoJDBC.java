package com.aula.projetocursosfx.model.dao.impl;

import com.aula.projetocursosfx.db.DB;
import com.aula.projetocursosfx.model.entities.Aluno;
import com.aula.projetocursosfx.model.entities.Curso;
import com.aula.projetocursosfx.model.entities.Matricula;

import java.sql.*;
import java.util.ArrayList;
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
            st = connection.prepareStatement("insert into matricula(data, status, aluno, curso, valor,dataPagamento, statusPagamento) values(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            st.setDate(1,obj.getData());
            st.setString(2,obj.getStatus());
            st.setInt(3,obj.getAluno().getId());
            st.setInt(4,obj.getCurso().getId());
            st.setDouble(5,obj.getValor());
            st.setDate(6,obj.getDataPagamento());
            st.setString(7, obj.getStatusPagamento());
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
        PreparedStatement st = null;
        try {
            st =connection.prepareStatement("update matricula set data=?, status =?, aluno=?, curso=? where id = ?");
            st.setDate(1,obj.getData());
            st.setString(2,obj.toString());
            st.setInt(3,obj.getAluno().getId());
            st.setInt(4,obj.getCurso().getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DB.closeStatement(st);
        }

    }

    public void deleteByID(Integer id){
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement("delete from matricula where id = ?");
            st.setInt(1,id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DB.closeStatement(st);
        }
    }

    public Matricula findByID(Integer id){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = connection.prepareStatement("select * from matricula where id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()){
                return new Matricula(rs.getInt("id"),rs.getDate("data"),rs.getString("status"),new Aluno(rs.getInt("aluno")),new Curso(rs.getInt("curso")),rs.getDouble("valor"),rs.getDate("dataPagamento"),rs.getString("statusPagamento"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return null;
    }

    public List<Matricula> findAll(){
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = connection.prepareStatement("select * from matricula");
            rs = st.executeQuery();
            List<Matricula> lista = new ArrayList<>();

            while (rs.next()){
                lista.add(new Matricula(rs.getInt("id"),rs.getDate("data"),rs.getString("status"),new Aluno(rs.getInt("aluno")),new Curso(rs.getInt("curso")),rs.getDouble("valor"),rs.getDate("dataPagamento"),rs.getString("statusPagamento")));
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

}

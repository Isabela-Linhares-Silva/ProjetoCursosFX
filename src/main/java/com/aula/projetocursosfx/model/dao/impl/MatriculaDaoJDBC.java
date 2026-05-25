package com.aula.projetocursosfx.model.dao.impl;

import com.aula.projetocursosfx.db.DB;
import com.aula.projetocursosfx.model.dao.MatriculaDao;
import com.aula.projetocursosfx.model.entities.Aluno;
import com.aula.projetocursosfx.model.entities.Curso;
import com.aula.projetocursosfx.model.entities.Matricula;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDaoJDBC implements MatriculaDao {
    private Connection connection;

    public MatriculaDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    public void insert(Matricula obj){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = connection.prepareStatement("insert into matricula(status, aluno_id, curso_id, valor,data_pagamento, status_pagamento) values(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1,obj.getStatus());
            st.setInt(2,obj.getAluno().getId());
            st.setInt(3,obj.getCurso().getId());
            st.setDouble(4,obj.getValor());
            if (obj.getDataPagamento() != null) {
                st.setDate(5, Date.valueOf(obj.getDataPagamento()));
            } else {
                st.setNull(5, Types.DATE);
            }
            st.setString(6, obj.getStatusPagamento());
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
            st = connection.prepareStatement(
                    "UPDATE matricula SET status=?, data_pagamento=?, status_pagamento=? WHERE id=?"
            );
            st.setString(1, obj.getStatus());
            if (obj.getDataPagamento() != null) {
                st.setDate(2, Date.valueOf(obj.getDataPagamento()));
            } else {
                st.setNull(2, Types.DATE);
            }
            st.setString(3, obj.getStatusPagamento());
            st.setInt(4, obj.getId());

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

    public Matricula findByID(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = connection.prepareStatement("select * from matricula where id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {

                Date dataSql = rs.getDate("data_pagamento");
                LocalDate dataPagamento = null;

                if (dataSql != null) {
                    dataPagamento = dataSql.toLocalDate();
                }

                return new Matricula(
                        rs.getInt("id"),
                        rs.getString("status"),
                        new Aluno(rs.getInt("aluno_id")),
                        new Curso(rs.getInt("curso_id")),
                        rs.getDouble("valor"),
                        dataPagamento,
                        rs.getString("status_pagamento")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
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
                Date dataSql = rs.getDate("data_pagamento");
                LocalDate dataPagamento = null;
                if (dataSql != null) {
                    dataPagamento = dataSql.toLocalDate();
                }

                lista.add(new Matricula(rs.getInt("id") ,rs.getString("status"),new Aluno(rs.getInt("aluno_id")),new Curso(rs.getInt("curso_id")),rs.getDouble("valor"),rs.getDate("data_pagamento").toLocalDate(),rs.getString("status_pagamento")));
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

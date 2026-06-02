package com.aula.projetocursosfx.model.dao.impl;

import com.aula.projetocursosfx.db.DB;
import com.aula.projetocursosfx.exceptions.MatriculaNaoEncontradaException;
import com.aula.projetocursosfx.model.dao.MatriculaDao;
import com.aula.projetocursosfx.model.entities.Aluno;
import com.aula.projetocursosfx.model.entities.Curso;
import com.aula.projetocursosfx.model.entities.Matricula;
import com.aula.projetocursosfx.model.entities.Professor;

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

    @Override
    public Matricula findByID(Integer id)
            throws MatriculaNaoEncontradaException {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = connection.prepareStatement(
                    "SELECT m.*, " +
                            "a.nome AS aluno_nome, a.email, " +
                            "c.nome AS curso_nome, c.preco, c.carga_horaria, c.professor_id " +
                            "FROM matricula m " +
                            "JOIN aluno a ON m.aluno_id = a.id " +
                            "JOIN curso c ON m.curso_id = c.id " +
                            "WHERE m.id = ?"
            );

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {

                Date dataSql = rs.getDate("data_pagamento");
                LocalDate dataPagamento = null;

                if (dataSql != null) {
                    dataPagamento = dataSql.toLocalDate();
                }

                Aluno aluno = new Aluno(
                        rs.getInt("aluno_id"),
                        rs.getString("aluno_nome"),
                        rs.getString("email")
                );

                Curso curso = new Curso(
                        rs.getInt("curso_id"),
                        rs.getString("curso_nome"),
                        rs.getInt("carga_horaria"),
                        rs.getDouble("preco"),
                        new Professor(rs.getInt("professor_id"))
                );

                return new Matricula(
                        rs.getInt("id"),
                        rs.getString("status"),
                        aluno,
                        curso,
                        rs.getDouble("valor"),
                        dataPagamento,
                        rs.getString("status_pagamento")
                );
            }

            throw new MatriculaNaoEncontradaException(
                    "Matrícula com ID " + id + " não encontrada."
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    public List<Matricula> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = connection.prepareStatement(
                    "SELECT m.*, " +
                            "a.nome AS aluno_nome, a.email, " +
                            "c.nome AS curso_nome, c.preco " +
                            "FROM matricula m " +
                            "JOIN aluno a ON m.aluno_id = a.id " +
                            "JOIN curso c ON m.curso_id = c.id"
            );

            rs = st.executeQuery();

            List<Matricula> lista = new ArrayList<>();

            while (rs.next()) {

                Date dataSql = rs.getDate("data_pagamento");
                LocalDate dataPagamento = null;

                if (dataSql != null) {
                    dataPagamento = dataSql.toLocalDate();
                }

                Aluno aluno = new Aluno(
                        rs.getInt("aluno_id"),
                        rs.getString("aluno_nome"),
                        rs.getString("email")
                );

                Curso curso = new Curso(
                        rs.getInt("curso_id"),
                        rs.getString("curso_nome"),
                        null, // carga horaria (se quiser, adiciona no SELECT)
                        rs.getDouble("preco"),
                        null // professor
                );

                lista.add(new Matricula(
                        rs.getInt("id"),
                        rs.getString("status"),
                        aluno,
                        curso,
                        rs.getDouble("valor"),
                        dataPagamento,
                        rs.getString("status_pagamento")
                ));
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

}

package com.aula.projetocursosfx.model.dao.impl;

import com.aula.projetocursosfx.db.DB;
import com.aula.projetocursosfx.model.dao.CursoDao;
import com.aula.projetocursosfx.model.entities.Curso;
import com.aula.projetocursosfx.model.entities.Professor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDaoJDBC implements CursoDao {
    private Connection connection;

    public CursoDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    public void insert(Curso obj){
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = connection.prepareStatement("insert into curso(nome,carga_horaria,preco,professor_id) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getNome());
            st.setInt(2,obj.getCargaHoraria());
            st.setDouble(3,obj.getPreco());
            st.setInt(4,obj.getProfessor().getId());

            int linhas = st.executeUpdate();
            if (linhas!=0){
                rs= st.getGeneratedKeys();

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

    public void update(Curso obj){
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(
                    "update curso set nome=?, carga_horaria=?, preco=?, professor_id=? where id=?"
            );

            st.setString(1, obj.getNome());
            st.setInt(2, obj.getCargaHoraria());
            st.setDouble(3,obj.getPreco());
            st.setInt(4,obj.getProfessor().getId());
            st.setInt(5, obj.getId());

            st.executeUpdate();

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            DB.closeStatement(st);
        }
    }

    public void deleteByID(Integer id){
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement("delete from curso where id = ?");
            st.setInt(1,id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally{
            DB.closeStatement(st);
        }

    }

    public Curso findByID(Integer id){
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = connection.prepareStatement(
                    "SELECT c.*, " +
                            "p.nome AS professor_nome, p.especialidade " +
                            "FROM curso c " +
                            "JOIN professor p ON c.professor_id = p.id " +
                            "WHERE c.id = ?"
            );

            st.setInt(1,id);
            rs= st.executeQuery();

            if (rs.next()){

                Professor professor = new Professor(
                        rs.getInt("professor_id"),
                        rs.getString("professor_nome"),
                        rs.getString("especialidade")
                );

                return new Curso(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("carga_horaria"),
                        rs.getDouble("preco"),
                        professor
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

    public List<Curso> findAll(){
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = connection.prepareStatement(
                    "SELECT c.*, " +
                            "p.nome AS professor_nome, p.especialidade " +
                            "FROM curso c " +
                            "JOIN professor p ON c.professor_id = p.id"
            );

            rs = st.executeQuery();

            List<Curso> lista = new ArrayList<>();

            while (rs.next()){

                Professor professor = new Professor(
                        rs.getInt("professor_id"),
                        rs.getString("professor_nome"),
                        rs.getString("especialidade")
                );

                lista.add(new Curso(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("carga_horaria"),
                        rs.getDouble("preco"),
                        professor
                ));
            }

            return lista;

        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }
}

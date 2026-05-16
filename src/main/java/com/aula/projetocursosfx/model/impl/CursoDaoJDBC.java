package com.aula.projetocursosfx.model.impl;

import com.aula.projetocursosfx.db.DB;
import com.aula.projetocursosfx.model.entities.Aluno;
import com.aula.projetocursosfx.model.entities.Curso;
import com.aula.projetocursosfx.model.entities.Professor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDaoJDBC {
    private Connection connection;

    public CursoDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    public void insert(Curso obj){
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = connection.prepareStatement("insert into curso(nome,cargaHoraria,preco,professor) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
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
                    "update aluno set nome=?, cargaHoraria=?, preco=?, professor=? where id=?"
            );

            st.setString(1, obj.getNome());
            st.setInt(2, obj.getCargaHoraria());
            st.setDouble(3,obj.getPreco());
            st.setInt(4,obj.getProfessor().getId());

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
            st = connection.prepareStatement("select * from curso where id =?");
            st.setInt(1,id);
            rs= st.executeQuery();
            if (rs.next()){
                return new Curso(rs.getInt("id"),rs.getString("nome"));
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

    public List<Curso> findAll(){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = connection.prepareStatement("select * from curso");

            rs = st.executeQuery();
            List<Curso> lista = new ArrayList<>();

            while (rs.next()){
                lista.add(new Curso(rs.getInt("id"), rs.getString("nome"), rs.getInt("cargaHoraria"),rs.getDouble("preco"),new Professor(rs.getInt("professor"))));
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

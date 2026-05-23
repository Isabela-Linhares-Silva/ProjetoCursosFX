package com.aula.projetocursosfx.model.dao.impl;

import com.aula.projetocursosfx.db.DB;
import com.aula.projetocursosfx.model.dao.ProfessorDao;
import com.aula.projetocursosfx.model.entities.Professor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDaoJDBC implements ProfessorDao {
    private Connection connection;

    public ProfessorDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    public void insert(Professor obj){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = connection.prepareStatement("insert into professor(nome,especialidade) values(?,?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getNome());
            st.setString(2, obj.getEspecialidade());
            int linhas = st.executeUpdate();

            if (linhas != 0){
                rs = st.getGeneratedKeys();

                if (rs.next()){
                    obj.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally{
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }

    }

    public void update(Professor obj){
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(
                    "update professor set nome=?, especialidade=? where id=?"
            );

            st.setString(1, obj.getNome());
            st.setString(2, obj.getEspecialidade());
            st.setInt(3, obj.getId());
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
            st = connection.prepareStatement("delete from professor where id = ?");
            st.setInt(1,id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       finally {
            DB.closeStatement(st);
        }
    }

    public Professor findByID(Integer id){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = connection.prepareStatement("select * from professor where id =?");
            st.setInt(1,id);
            rs = st.executeQuery();
            if (rs.next()){
                return new Professor(rs.getInt(1),rs.getString(2),rs.getString(3));
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

    public List<Professor> findAll(){
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = connection.prepareStatement("select * from professor");
            rs = st.executeQuery();
            List<Professor> lista = new ArrayList<>();

            while (rs.next()){
                lista.add(new Professor(rs.getInt("id"),rs.getString("nome"),rs.getString("especialidade")));
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

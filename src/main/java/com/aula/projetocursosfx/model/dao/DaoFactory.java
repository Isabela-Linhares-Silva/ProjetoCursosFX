package com.aula.projetocursosfx.model.dao;

import com.aula.projetocursosfx.db.DB;
import com.aula.projetocursosfx.model.dao.impl.*;

public interface DaoFactory {
    public static AlunoDaoJDBC cPerfumeDAO() {
        return new AlunoDaoJDBC(DB.getConnection());
    }

    public static CursoDaoJDBC cClienteDAO() {
        return new CursoDaoJDBC(DB.getConnection());
    }

    public static MatriculaDaoJDBC cMarcaDAO() {
        return new MatriculaDaoJDBC(DB.getConnection());
    }

    public static ProfessorDaoJDBC cRevendedorDAO() {
        return new ProfessorDaoJDBC(DB.getConnection());
    }
}


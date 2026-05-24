package com.aula.projetocursosfx.model.dao;

import com.aula.projetocursosfx.db.DB;
import com.aula.projetocursosfx.model.dao.impl.*;
import com.aula.projetocursosfx.model.entities.Matricula;

public interface DaoFactory {
    public static CursoDao createCursoDao(){
        return new CursoDaoJDBC(DB.getConnection());
    }

    public static AlunoDao createAlunoDao(){
        return new AlunoDaoJDBC(DB.getConnection());
    }

    public static MatriculaDao createMatriculaDao(){
        return new MatriculaDaoJDBC(DB.getConnection());
    }

    public static ProfessorDao createProfessorDao(){return new ProfessorDaoJDBC(DB.getConnection());
    }
}


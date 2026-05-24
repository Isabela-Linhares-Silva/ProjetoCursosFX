package com.aula.projetocursosfx.model.dao;

import com.aula.projetocursosfx.db.DB;
import com.aula.projetocursosfx.model.dao.impl.*;

public interface DaoFactory {
    public static CursoDao createCursoDao(){
        return new CursoDaoJDBC(DB.getConnection());
    }

    public static AlunoDao createAlunoDao(){
        return new AlunoDaoJDBC(DB.getConnection());
    }
}


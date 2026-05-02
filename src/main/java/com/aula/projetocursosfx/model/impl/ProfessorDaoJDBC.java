package com.aula.projetocursosfx.model.impl;

import java.sql.Connection;

public class ProfessorDaoJDBC {
    private Connection connection;

    public ProfessorDaoJDBC(Connection connection) {
        this.connection = connection;
    }
}

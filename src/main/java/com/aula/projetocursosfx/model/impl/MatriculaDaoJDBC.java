package com.aula.projetocursosfx.model.impl;

import java.sql.Connection;

public class MatriculaDaoJDBC {
    private Connection connection;

    public MatriculaDaoJDBC(Connection connection) {
        this.connection = connection;
    }
}

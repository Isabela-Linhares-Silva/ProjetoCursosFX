package com.aula.projetocursosfx.model.impl;

import java.sql.Connection;

public class AlunoDaoJDBC {
    private Connection connection;

    public AlunoDaoJDBC(Connection connection) {
        this.connection = connection;
    }
}

package com.aula.projetocursosfx.model.impl;

import java.sql.Connection;

public class CursoDaoJDBC {
    private Connection connection;

    public CursoDaoJDBC(Connection connection) {
        this.connection = connection;
    }
}

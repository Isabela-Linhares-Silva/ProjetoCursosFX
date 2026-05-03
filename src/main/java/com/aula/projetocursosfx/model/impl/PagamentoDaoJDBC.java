package com.aula.projetocursosfx.model.impl;

import java.sql.Connection;

public class PagamentoDaoJDBC {
    private Connection connection;

    public PagamentoDaoJDBC(Connection connection) {
        this.connection = connection;
    }
}

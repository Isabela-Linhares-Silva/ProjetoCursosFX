package com.aula.projetocursosfx.controller;

import com.aula.projetocursosfx.exceptions.CursoNaoEncontradoException;
import com.aula.projetocursosfx.model.dao.DaoFactory;
import com.aula.projetocursosfx.model.entities.Curso;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BuscarCursoController {
    @FXML
    private TextField codigoCurso;
    @FXML
    private Label nomeCurso;

    @FXML
    public void onBuscarCursoClicked() throws CursoNaoEncontradoException {
        Integer id = Integer.parseInt(codigoCurso.getText());
        Curso curso = DaoFactory.createCursoDao().findByID(id);
        nomeCurso.setText(curso.getNome());
    }

    @FXML
    public void onDeletarCursoClicked(){
        Integer id = Integer.parseInt(codigoCurso.getText());
        DaoFactory.createCursoDao().deleteByID(id);
    }

}

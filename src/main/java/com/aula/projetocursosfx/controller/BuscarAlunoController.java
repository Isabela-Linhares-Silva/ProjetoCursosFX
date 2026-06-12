package com.aula.projetocursosfx.controller;

import com.aula.projetocursosfx.exceptions.AlunoNaoEncontradoException;
import com.aula.projetocursosfx.model.dao.DaoFactory;
import com.aula.projetocursosfx.model.entities.Aluno;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BuscarAlunoController {
    @FXML
    private TextField idAluno;
    @FXML
    private Label nomeAluno;

    @FXML
    public void onBuscarAlunoClicked() throws AlunoNaoEncontradoException {
        Integer id = Integer.parseInt(idAluno.getText());
        Aluno aluno = DaoFactory.createAlunoDao().findByID(id);
        nomeAluno.setText(aluno.getNome());
    }

    @FXML
    public void onDeletarALunoClicked(){
        Integer id = Integer.parseInt(idAluno.getText());
        DaoFactory.createAlunoDao().deleteByID(id);
    }
}

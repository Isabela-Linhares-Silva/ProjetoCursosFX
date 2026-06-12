package com.aula.projetocursosfx.controller;

import com.aula.projetocursosfx.exceptions.EmailInvalidoException;
import com.aula.projetocursosfx.model.dao.DaoFactory;
import com.aula.projetocursosfx.model.entities.Aluno;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


public class CadastrarAlunoController {
    @FXML
    private TextField nomeAluno;

    @FXML
    private TextField emailAluno;

    @FXML
    private void onCadastrarAlunoClicked() throws EmailInvalidoException {
        Aluno a = new Aluno(nomeAluno.getText(),emailAluno.getText());
        DaoFactory.createAlunoDao().insert(a);
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.show();
        alerta.setTitle("Cadastro");
        alerta.setContentText("Cadastrado com sucesso");
        nomeAluno.setText("");

    }
}

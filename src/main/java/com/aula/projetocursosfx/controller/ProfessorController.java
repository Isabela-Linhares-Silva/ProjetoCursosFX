package com.aula.projetocursosfx.controller;

import com.aula.projetocursosfx.model.dao.DaoFactory;
import com.aula.projetocursosfx.model.entities.Aluno;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ProfessorController {
    @FXML
    private TextField nomeProfessor;

    @FXML
    private TextField especialidadeProfessor;

    @FXML
    private void onCadastrarProfessorClicked(){
        Aluno a = new Aluno(nomeProfessor.getText(),especialidadeProfessor.getText());
        DaoFactory.createAlunoDao().insert(a);
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.show();
        alerta.setTitle("Cadastro");
        alerta.setContentText("Cadastrado com sucesso");
        nomeProfessor.setText("");

    }
    //=======================================CADASTRAR=======================================


}

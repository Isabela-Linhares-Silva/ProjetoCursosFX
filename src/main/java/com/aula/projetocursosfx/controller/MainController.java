package com.aula.projetocursosfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainController {

    @FXML
    private AnchorPane contentPane;

    private void carregarTela (String fxml){
        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "/com/aula/projetocursosfx/controller/" + fxml
                            )
                    );

            Parent root = loader.load();

            contentPane.getChildren().clear();
            contentPane.getChildren().add(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onProfessorClicked() {
        carregarTela("professor-view.fxml");
    }

    @FXML
    private void onAlunoClicked(){
        carregarTela("aluno-view.fxml");
    }

    @FXML
    private void onCursoClicked() {
        carregarTela("curso-view.fxml");
    }

    @FXML
    private void onMatriculaClicked()  {
        carregarTela("matricula-view.fxml");
    }
}
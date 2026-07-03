package com.aula.projetocursosfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField emailLogin;

    @FXML
    private PasswordField senhaLogin;

    @FXML
    private Rectangle cardLogin;

    @FXML
    private Button loginButton;

    @FXML
    private void onCadastrarTelaClicked() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/aula/projetocursosfx/controller/cadastro-view.fxml"));

        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    @FXML
    private void onLoginClicked() throws IOException {

        String email = emailLogin.getText().trim();
        String senha = senhaLogin.getText().trim();

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/aula/projetocursosfx/controller/main-view.fxml"));

        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.setScene(new Scene(loader.load(), 1200, 700));
        stage.setTitle("AcademiSys");
        stage.show();
    }

    @FXML
    public void initialize() {

        DropShadow shadow = new DropShadow();
        shadow.setRadius(25);
        shadow.setOffsetY(6);
        shadow.setColor(Color.rgb(0, 0, 0, 0.25));

        cardLogin.setEffect(shadow);
    }
}
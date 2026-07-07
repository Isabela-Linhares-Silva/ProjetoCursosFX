package com.aula.projetocursosfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class CadastroController {
    @FXML
    private Label academiSysLabel;

    @FXML
    private TextField emailCadastro;

    @FXML
    private PasswordField senhaCadastro;

    @FXML
    private PasswordField confirmaSenhaCadastro;

    @FXML
    private Rectangle cardCadastro;

    @FXML
    private Button cadastroButton;

    @FXML
    private void onCadastrarClicked() {

        String email = emailCadastro.getText().trim();
        String senha = senhaCadastro.getText().trim();
        String confirma = confirmaSenhaCadastro.getText().trim();

        if(email.isEmpty() || senha.isEmpty() || confirma.isEmpty()){
            System.out.println("Preencha todos os campos!");
            return;
        }

        if(!senha.equals(confirma)){
            System.out.println("As senhas não estão iguais!");
            return;
        }

        System.out.println("Cadastro realizado!");
    }

    @FXML
    private void voltarLogin() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/aula/projetocursosfx/controller/login-view.fxml"));

        Stage stage = (Stage) cadastroButton.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Login");
        stage.show();
    }

    @FXML
    private void mouseEntrou() {
        academiSysLabel.setStyle("-fx-text-fill: #2563EB; -fx-cursor: hand;");
    }

    @FXML
    private void mouseSaiu() {
        academiSysLabel.setStyle("-fx-text-fill: #1E3A8A; -fx-cursor: hand;");
    }

    @FXML
    public void initialize(){

        DropShadow shadow = new DropShadow();
        shadow.setRadius(25);
        shadow.setOffsetY(6);
        shadow.setColor(Color.rgb(0,0,0,0.25));

        cardCadastro.setEffect(shadow);
    }

    @FXML
    private void mouseEntrouBotao() {
        cadastroButton.setStyle(
                "-fx-background-color:#1D4ED8;" +
                        "-fx-background-radius:8;" +
                        "-fx-cursor: hand;"
        );

        cadastroButton.setCursor(Cursor.HAND);
    }

    @FXML
    private void mouseSaiuBotao() {
        cadastroButton.setStyle(
                "-fx-background-color:#2563EB;" +
                        "-fx-background-radius:8;"
        );

        cadastroButton.setCursor(Cursor.DEFAULT);
    }
}

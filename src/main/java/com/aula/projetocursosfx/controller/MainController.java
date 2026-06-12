package com.aula.projetocursosfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainController {

    @FXML
    private AnchorPane contentPane;

    @FXML
    private void abrirProfessor() throws IOException {

        Parent tela = FXMLLoader.load(
                getClass().getResource(
                        "/com.aula.projetocursosfx.controller/cadastrar-professor-view.fxml"));

        contentPane.getChildren().setAll(tela);
    }

    @FXML
    private void abrirAluno() throws IOException {

        Parent tela = FXMLLoader.load(
                getClass().getResource(
                        "/com.aula.projetocursosfx.controller/cadastrar-aluno-view.fxml"));

        contentPane.getChildren().setAll(tela);
    }

    @FXML
    private void abrirCurso() throws IOException {

        Parent tela = FXMLLoader.load(
                getClass().getResource(
                        "/com.aula.projetocursosfx.controller/cadastrar-curso-view.fxml"));

        contentPane.getChildren().setAll(tela);
    }

    @FXML
    private void abrirMatricula() {

        System.out.println("Tela de matrícula");
    }
}
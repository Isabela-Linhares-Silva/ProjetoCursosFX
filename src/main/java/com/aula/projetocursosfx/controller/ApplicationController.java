package com.aula.projetocursosfx.controller;

import com.aula.projetocursosfx.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ApplicationController {
    @FXML
    protected void onBuscarCursoClicked(){
        Application.criarTela("controller/buscar-curso-view.fxml");
    }
    @FXML
    protected void onCadastrarCursoClicked(){
        Application.criarTela("controller/cadastrar-curso-view.fxml");
    }
    @FXML
    protected void onCadastrarAlunoClicked(){
        Application.criarTela("controller/cadastrar-aluno-view.fxml");
    }
    @FXML
    protected void onBuscarAlunoClicked(){Application.criarTela("controller/buscar-aluno-view.fxml");}
    @FXML
    protected void onBuscarProfessorClicked(){Application.criarTela("controller/buscar-professor-view.fxml");}
    @FXML
    protected void onCadastrarProfessorClicked(){
        Application.criarTela("controller/cadastrar-professor-view.fxml");
    }
}

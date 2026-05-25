package com.aula.projetocursosfx.controller;

import com.aula.projetocursosfx.model.dao.DaoFactory;
import com.aula.projetocursosfx.model.entities.Curso;
import com.aula.projetocursosfx.model.entities.Professor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CadastrarCursoController implements Initializable {
    @FXML
    private TextField nomeCurso;

    @FXML
    private TextField cargaHorariaCurso;

    @FXML
    private TextField precoCurso;

    @FXML
    private ComboBox<Professor> professores;

    @FXML
    private void onCadastrarCursoClicked(){
        String nome = nomeCurso.getText();
        int carga = Integer.parseInt(cargaHorariaCurso.getText());
        double preco = Double.parseDouble(precoCurso.getText());
        Professor prof = professores.getValue();

        Curso c = new Curso(nome, carga, preco, prof);

        DaoFactory.createCursoDao().insert(c);

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Cadastro");
        alerta.setContentText("Cadastrado com sucesso");
        alerta.show();

        nomeCurso.setText("");
        cargaHorariaCurso.setText("");
        precoCurso.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {//executado assim que a tela e iniciada
        try {
            List<Professor> listaProfessores = DaoFactory.createProfessorDao().findAll();
            List<String> nomeProfessores = new ArrayList<>();

            for(Professor p : listaProfessores){
                nomeProfessores.add(p.getNome());
            }

            ObservableList obs = FXCollections.observableArrayList(nomeProfessores);
            professores.setItems(obs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

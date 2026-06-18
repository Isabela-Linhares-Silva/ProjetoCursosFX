package com.aula.projetocursosfx.controller;

import com.aula.projetocursosfx.exceptions.ProfessorNaoEncontradoException;
import com.aula.projetocursosfx.model.dao.DaoFactory;
import com.aula.projetocursosfx.model.entities.Professor;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ProfessorController {

    @FXML
    private TextField idProfessor;

    @FXML
    private TextField nomeProfessor;

    @FXML
    private TextField especialidadeProfessor;

    // ================= CADASTRAR =================

    @FXML
    private void onCadastrarProfessorClicked() {

        Professor professor = new Professor(
                nomeProfessor.getText(),
                especialidadeProfessor.getText()
        );

        DaoFactory.createProfessorDao().insert(professor);

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Cadastro");
        alerta.setHeaderText(null);
        alerta.setContentText("Professor cadastrado com sucesso!");
        alerta.showAndWait();

        nomeProfessor.clear();
        especialidadeProfessor.clear();
    }

    // ================= BUSCAR =================

    @FXML
    private void onBuscarProfessorClicked() {

        try {

            Integer id = Integer.parseInt(idProfessor.getText());

            Professor professor =
                    DaoFactory.createProfessorDao().findByID(id);

            nomeProfessor.setText(professor.getNome());
            especialidadeProfessor.setText(professor.getEspecialidade());

        }
        catch (ProfessorNaoEncontradoException e) {

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText(e.getMessage());
            alerta.showAndWait();
        }
        catch (NumberFormatException e) { //quando digitar um id invalido ou id vazio

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Digite um ID válido.");
            alerta.showAndWait();
        }
    }
    // ================= ATUALIZAR =================
    @FXML
    private void onAtualizarProfessorClicked() {

        try {

            Professor professor = new Professor(
                    Integer.parseInt(idProfessor.getText()),
                    nomeProfessor.getText(),
                    especialidadeProfessor.getText()
            );

            DaoFactory.createProfessorDao().update(professor);

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Atualização");
            alerta.setHeaderText(null);
            alerta.setContentText("Professor atualizado com sucesso!");
            alerta.showAndWait();

        }
        catch (NumberFormatException e) {

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Digite um ID válido.");
            alerta.showAndWait();
        }
    }

    // ================= LIMPAR =================

    @FXML
    private void onLimparClicked() {

        idProfessor.clear();
        nomeProfessor.clear();
        especialidadeProfessor.clear();
    }
}
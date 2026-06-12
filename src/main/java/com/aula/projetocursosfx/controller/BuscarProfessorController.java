package com.aula.projetocursosfx.controller;

import com.aula.projetocursosfx.exceptions.ProfessorNaoEncontradoException;
import com.aula.projetocursosfx.model.dao.DaoFactory;
import com.aula.projetocursosfx.model.entities.Professor;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BuscarProfessorController {
    @FXML
    private TextField idProfessor;
    @FXML
    private Label nomeProfessor;

    @FXML
    public void onBuscarProfessorClicked() throws ProfessorNaoEncontradoException {
        Integer id = Integer.parseInt(idProfessor.getText());
        try{
        Professor professor = DaoFactory.createProfessorDao().findByID(id);
        nomeProfessor.setText(professor.getNome());
        } catch (ProfessorNaoEncontradoException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void onDeletarProfessorClicked(){
        Integer id = Integer.parseInt(idProfessor.getText());
        DaoFactory.createProfessorDao().deleteByID(id);
    }
}

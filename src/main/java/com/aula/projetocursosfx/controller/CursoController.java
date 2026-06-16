package com.aula.projetocursosfx.controller;

import com.aula.projetocursosfx.exceptions.ProfessorNaoEncontradoException;
import com.aula.projetocursosfx.model.dao.DaoFactory;
import com.aula.projetocursosfx.model.entities.Curso;
import com.aula.projetocursosfx.model.entities.Professor;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

//id , nome, carga horaria,preço professor
public class CursoController implements Initializable {

        @FXML
        private TextField idCurso;

        @FXML
        private TextField nomeCurso;

        @FXML
        private TextField cargaHorariaCurso;

        @FXML
        private TextField precoCurso;

        @FXML
        private ComboBox<Professor> professores;

        // ================= CADASTRAR =================

        @FXML
        private void onCadastrarCursoClicked() {

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

            nomeCurso.clear();
            cargaHorariaCurso.clear();
            precoCurso.clear();
            professores.setValue(null);

        }

        // ================= BUSCAR =================

        @FXML
        private void onBuscarCursoClicked() {

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
        }
        // ================= ATUALIZAR =================
        @FXML
        private void onAtualizarCursoClicked() {

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

        // ================= LIMPAR =================

        @FXML
        private void onLimparClicked() {

            idProfessor.clear();
            nomeProfessor.clear();
            especialidadeProfessor.clear();
        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {

            professores.getItems().addAll(
                    DaoFactory.createProfessorDao().findAll()
            );
        }
    }
}


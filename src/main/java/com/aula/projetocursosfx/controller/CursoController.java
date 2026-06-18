package com.aula.projetocursosfx.controller;

import com.aula.projetocursosfx.exceptions.CursoNaoEncontradoException;
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
            try {
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
            } catch (NumberFormatException e) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Erro");
                alerta.setHeaderText(null);
                alerta.setContentText("Digite novamente");
                alerta.showAndWait();
            }


            nomeCurso.clear();
            cargaHorariaCurso.clear();
            precoCurso.clear();
            professores.setValue(null);

        }

        // ================= BUSCAR =================

        @FXML
        private void onBuscarCursoClicked() {

            try {

                Integer id = Integer.parseInt(idCurso.getText());

                Curso curso = DaoFactory.createCursoDao().findByID(id);

                nomeCurso.setText(curso.getNome());
                cargaHorariaCurso.setText(String.valueOf(curso.getCargaHoraria()));
                precoCurso.setText(String.valueOf(curso.getPreco()));
                professores.setValue(curso.getProfessor());

            }
            catch (CursoNaoEncontradoException e) {

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
        private void onAtualizarCursoClicked() {
            try {
                Curso curso = new Curso(
                        Integer.parseInt(idCurso.getText()),
                        nomeCurso.getText(),
                        Integer.parseInt(cargaHorariaCurso.getText()),
                        Double.parseDouble(precoCurso.getText()),
                        professores.getValue()
                );

                DaoFactory.createCursoDao().update(curso);

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Atualização");
                alerta.setHeaderText(null);
                alerta.setContentText("Curso atualizado com sucesso!");
                alerta.showAndWait();
            } catch (NumberFormatException e) {

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

            idCurso.clear();
            nomeCurso.clear();
            cargaHorariaCurso.clear();
            precoCurso.clear();
            professores.setValue(null);
        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {

            professores.getItems().addAll(
                    DaoFactory.createProfessorDao().findAll()
            );
        }
    }



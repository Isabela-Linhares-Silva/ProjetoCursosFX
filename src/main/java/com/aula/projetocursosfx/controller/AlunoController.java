package com.aula.projetocursosfx.controller;

import com.aula.projetocursosfx.exceptions.AlunoNaoEncontradoException;
import com.aula.projetocursosfx.exceptions.EmailInvalidoException;
import com.aula.projetocursosfx.model.dao.DaoFactory;
import com.aula.projetocursosfx.model.entities.Aluno;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class AlunoController {


        @FXML
        private TextField idAluno;

        @FXML
        private TextField nomeAluno;

        @FXML
        private TextField emailAluno;

        @FXML
        private TableView<Aluno> tableAluno;

        @FXML
        private TableColumn<Aluno, Integer> colId;

        @FXML
        private TableColumn<Aluno, String> colNome;

        @FXML
        private TableColumn<Aluno, String> colEmail;

        @FXML
        public void initialize() {

            colId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

            atualizarTabela();
        }

        private void atualizarTabela() {

            ObservableList<Aluno> lista =
                    FXCollections.observableArrayList(
                            DaoFactory.createAlunoDao().findAll());

            tableAluno.setItems(lista);
        }

        // ================= CADASTRAR =================

        @FXML
        private void onCadastrarAlunoClicked() {
            try {
                Aluno aluno = new Aluno(
                        nomeAluno.getText(),
                        emailAluno.getText()
                );

                DaoFactory.createAlunoDao().insert(aluno);
                atualizarTabela();

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Cadastro");
                alerta.setHeaderText(null);
                alerta.setContentText("Aluno cadastrado com sucesso!");
                alerta.showAndWait();
            } catch (EmailInvalidoException e) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Erro");
                alerta.setHeaderText(null);
                alerta.setContentText(e.getMessage());
                alerta.showAndWait();
                return;
            }


            nomeAluno.clear();
            emailAluno.clear();
        }

        // ================= BUSCAR =================

        @FXML
        private void onBuscarAlunoClicked() {

            try {

                Integer id = Integer.parseInt(idAluno.getText());

                Aluno aluno =
                        DaoFactory.createAlunoDao().findByID(id);
                atualizarTabela();

                nomeAluno.setText(aluno.getNome());
                emailAluno.setText(aluno.getEmail());

            }
            catch (AlunoNaoEncontradoException e) {

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Erro");
                alerta.setHeaderText(null);
                alerta.setContentText(e.getMessage());
                alerta.showAndWait();
            }catch (NumberFormatException e) { //quando digitar um id invalido ou id vazio

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Erro");
                alerta.setHeaderText(null);
                alerta.setContentText("Digite um ID válido.");
                alerta.showAndWait();
            }
        }
        // ================= ATUALIZAR =================
        @FXML
        private void onAtualizarAlunoClicked(){
            try {
                Aluno aluno = new Aluno(
                        Integer.parseInt(idAluno.getText()),
                        nomeAluno.getText(),
                        emailAluno.getText()
                );

                DaoFactory.createAlunoDao().update(aluno);
                atualizarTabela();
            } catch (EmailInvalidoException e) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Erro");
                alerta.setHeaderText(null);
                alerta.setContentText(e.getMessage());
                alerta.showAndWait();
                return;
            }
            catch (NumberFormatException e) {

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Erro");
                alerta.setHeaderText(null);
                alerta.setContentText("Digite um ID válido.");
                alerta.showAndWait();
                return;
            }


            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Atualização");
            alerta.setHeaderText(null);
            alerta.setContentText("Aluno atualizado com sucesso!");
            alerta.showAndWait();
        }

        // ================= LIMPAR =================

        @FXML
        private void onLimparClicked() {

            idAluno.clear();
            nomeAluno.clear();
            emailAluno.clear();
        }
    }


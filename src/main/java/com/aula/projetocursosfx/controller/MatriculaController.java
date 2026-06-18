package com.aula.projetocursosfx.controller;

import com.aula.projetocursosfx.exceptions.CursoJaMatriculadoException;
import com.aula.projetocursosfx.exceptions.MatriculaNaoEncontradaException;
import com.aula.projetocursosfx.exceptions.ProfessorNaoEncontradoException;
import com.aula.projetocursosfx.model.dao.DaoFactory;
import com.aula.projetocursosfx.model.entities.Aluno;
import com.aula.projetocursosfx.model.entities.Curso;
import com.aula.projetocursosfx.model.entities.Matricula;
import com.aula.projetocursosfx.model.entities.Professor;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class MatriculaController {
    @FXML
    private TextField idMatricula;

    @FXML
    private TextField statusMatricula;

    @FXML
    private TextField valorMatricula;

    @FXML
    private DatePicker dataPagamentoMatricula;

    @FXML
    private TextField statusPagamentoMatricula;

    @FXML
    private ComboBox<Aluno> alunos;

    @FXML
    private ComboBox<Curso> cursos;
    // ================= CADASTRAR =================

    @FXML
    private void onCadastrarMatriculaClicked() {

        try{
            String status = statusMatricula.getText();
            Double valor = Double.parseDouble(valorMatricula.getText());
            LocalDate data = dataPagamentoMatricula.getValue();
            Aluno aluno = alunos.getValue();
            Curso curso = cursos.getValue();
            String statusPagamento = "Pago";
            Matricula matricula = new Matricula();

            matricula.setStatus(status);
            matricula.setAluno(aluno);
            matricula.setCurso(curso);
            matricula.setValor(valor);
            matricula.setDataPagamento(data);
            matricula.setStatusPagamento(statusPagamento);

            DaoFactory.createMatriculaDao().insert(matricula);

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Cadastro");
            alerta.setHeaderText(null);
            alerta.setContentText("Matricula cadastrada com sucesso!");
            alerta.showAndWait();
        } catch (CursoJaMatriculadoException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText(e.getMessage());
            alerta.showAndWait();
            return;
        }
        statusMatricula.clear();
        valorMatricula.clear();
        dataPagamentoMatricula.setValue(null);
        statusPagamentoMatricula.clear();
        alunos.setValue(null);
        cursos.setValue(null);
    }

    // ================= BUSCAR =================

    @FXML
    private void onBuscarMatriculaClicked() {
        try {

            Integer id = Integer.parseInt(idMatricula.getText());

            Matricula matricula = DaoFactory.createMatriculaDao().findByID(id);

            statusMatricula.setText(matricula.getStatus());
            valorMatricula.setText(String.valueOf(matricula.getValor()));
            dataPagamentoMatricula.setValue(matricula.getDataPagamento());
            statusPagamentoMatricula.setText(matricula.getStatusPagamento());
            alunos.setValue(matricula.getAluno());
            cursos.setValue(matricula.getCurso());

        }
        catch (MatriculaNaoEncontradaException e) {

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
    private void onAtualizarMatriculaClicked() {
        try{
            Matricula matricula = new Matricula(
                    Integer.parseInt(idMatricula.getText()),
                    statusMatricula.getText(),
                    alunos.getValue(),
                    cursos.getValue(),
                    Double.parseDouble(valorMatricula.getText()),
                    dataPagamentoMatricula.getValue(),
                    statusPagamentoMatricula.getText()
            );

            DaoFactory.createMatriculaDao().update(matricula);

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Atualização");
            alerta.setHeaderText(null);
            alerta.setContentText("Matricula atualizada com sucesso!");
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
        idMatricula.clear();
        statusMatricula.clear();
        valorMatricula.clear();
        dataPagamentoMatricula.setValue(null);
        statusPagamentoMatricula.clear();
        alunos.setValue(null);
        cursos.setValue(null);
    }
    // ================= INITIALIZE =================
    @FXML
    public void initialize() {

        alunos.getItems().addAll(
                DaoFactory.createAlunoDao().findAll()
        );

        cursos.getItems().addAll(
                DaoFactory.createCursoDao().findAll()
        );
    }

}

package com.aula.projetocursosfx.model.entities;

import java.sql.Date;
import java.time.LocalDate;

public class Matricula {
    private Integer id;
    private String status;
    private Aluno aluno;
    private Curso curso;

    // oq veio da antiga classe Pagamento
    private Double valor;
    private LocalDate dataPagamento;
    private String statusPagamento;

    public Matricula(Integer id, String status, Aluno aluno, Curso curso, Double valor, LocalDate dataPagamento,String statusPagamento){
        this.id = id;
        this.status = status;
        this.aluno = aluno;
        this.curso = curso;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.statusPagamento = statusPagamento;
    }

    public Matricula() { }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Double getValor() {return valor;}
    public void setValor(Double valor) {this.valor = valor;}

    public LocalDate getDataPagamento() {return dataPagamento;}
    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getStatusPagamento() {return statusPagamento;}
    public void setStatusPagamento(String statusPagamento) {this.statusPagamento = statusPagamento;}

    @Override
    public String toString() {
        return "Matricula{" +
                "id: "+ id +
                ", aluno: " +(aluno != null ? aluno.getNome() : "null")+// se nao fizer isso pode dar NullPOinterException
                ", curso: "+ (curso != null ? curso.getNome() : "null") +
                ", status: "+ status+
                ", valor: "+ valor+
                ", data do pagamento: " + dataPagamento+
                ", status do pagamento: " + statusPagamento+
                "}";
    }
}

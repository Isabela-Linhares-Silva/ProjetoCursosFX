package com.aula.projetocursosfx.model.entities;

import java.sql.Date;

public class Matricula {
    private Integer id;
    private Date data;
    private String status;
    private Aluno aluno;
    private Curso curso;


    // oq veio da antiga classe Pagamento
    private Double valor;
    private Date dataPagamento;
    private String statusPagamento;

    public Matricula(Integer id, Date data, String status, Aluno aluno, Curso curso, Double valor, Date dataPagamento,String statusPagamento){
        this.id = id;
        this.data = data;
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

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
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

    public Date getDataPagamento() {return dataPagamento;}
    public void setDataPagamento(Date dataPagamento) {this.dataPagamento = dataPagamento;}

    public String getStatusPagamento() {return statusPagamento;}
    public void setStatusPagamento(String statusPagamento) {this.statusPagamento = statusPagamento;}

    @Override
    public String toString() {
        return "Matricula{" +
                "id: "+ id +
                ", aluno: " +(aluno != null ? aluno.getNome() : "null")+// se nao fizer isso pode dar NullPOinterException
                ", curso: "+ (curso != null ? curso.getNome() : "null") +
                ", data: "+ data+
                ", status: "+ status+
                "}";
    }
}

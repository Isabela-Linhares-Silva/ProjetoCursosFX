package com.aula.projetocursosfx.model.entities;

import java.sql.Date;

public class Matricula {
    private Integer id;
    private Date data;
    private String status;
    private Aluno aluno;
    private Curso curso;

    Matricula(Integer id, Date data, String status, Aluno aluno, Curso curso){
        this.id = id;
        this.data = data;
        this.status = status;
        this.aluno = aluno;
        this.curso = curso;
    }

    Matricula() { }

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

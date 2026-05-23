package com.aula.projetocursosfx.model.entities;

public class Curso {

    private Integer id;
    private String nome;
    private Integer cargaHoraria;
    private Double preco;
    private Professor professor;

    public Curso(Integer id, String nome, Integer cargaHoraria, Double preco, Professor professor) {
        this.id = id;//é auto incremento
        this.nome = nome;
        this.cargaHoraria= cargaHoraria;
        this.preco = preco;
        this.professor = professor;
    }
    public Curso( String nome, Integer cargaHoraria, Double preco, Professor professor) {
        this.nome = nome;
        this.cargaHoraria= cargaHoraria;
        this.preco = preco;
        this.professor = professor;
    }
    public Curso(Integer id, String nome) { //para procura de turma
        this.id = id;
        this.nome = nome;
    }
    public Curso(Integer id) {
        this.id = id;
    }
    public Curso() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id: " + id +
                ", nome: '" + nome + '\'' +
                ", cargaHoraria: " + cargaHoraria +
                ", preco: " + preco +
                ", professor: " + (professor != null ? professor.getNome() : "null") +
                '}';
    }
}

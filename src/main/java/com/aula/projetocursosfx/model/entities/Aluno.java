package com.aula.projetocursosfx.model.entities;

public class Aluno {
    private Integer id;
    private String nome;
    private String email;

    public Aluno(){ }

    public Aluno(Integer id){ this.id = id;}

    public Aluno(Integer id, String nome, String email){
        this.id = id;
        this.nome = nome;
        this.email = email;
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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Aluno{"+
                "id: "+id +
                ", nome: " + nome+
                ", email: " + email+
                "}";
    }
}

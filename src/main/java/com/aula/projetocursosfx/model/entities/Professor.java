package com.aula.projetocursosfx.model.entities;

public class Professor {
    private Integer id;
    private String nome;
    private String especialidade;

    public Professor(Integer id, String nome, String especialidade){
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
    }
    public Professor( String nome, String especialidade){
        this.nome = nome;
        this.especialidade = especialidade;
    }
    public Professor(Integer id){
        this.id = id;
    }

    public Professor(){ }



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

    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    @Override
    public String toString() {
        return "Professor{" +
                "id: "+ id +
                ", nome: " + nome+
                ", especialidade: "+ especialidade+
                '}';
    }
}

package com.aula.projetocursosfx.model.entities;

import java.sql.Date;

public class Pagamento {
    private Integer id;
    private Double valor;
    private Date data;
    private String status;
    private Matricula matricula;

    Pagamento(Integer id, Double valor, Date data, String status, Matricula matricula){
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.status = status;
        this.matricula = matricula;
    }

    Pagamento(){ }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
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

    public Matricula getMatricula() {
        return matricula;
    }
    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Pagamento{"+
                "id: "+ id +
                ", valor: " + valor+
                ", status: "+ status +
                ", data: " + data+
                ", matricula:" + matricula+// aqui nao precisa botar o parentesis pq se der null, nao vai dar exception
                "}";
    }
}

package com.aula.projetocursosfx.db;

import com.aula.projetocursosfx.model.dao.AlunoDao;
import com.aula.projetocursosfx.model.entities.Aluno;
import com.aula.projetocursosfx.model.impl.AlunoDaoJDBC;

import java.util.Scanner;

public class TesteMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("digite o id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("digite o nome: ");
        String nome = sc.nextLine();
        System.out.print("digite o email: ");
        String email = sc.next();

        AlunoDao aluno = new AlunoDaoJDBC(DB.getConnection());

        aluno.insert(new Aluno(id, nome, email));

        System.out.println("aluno inserido com sucesso");
    }
}

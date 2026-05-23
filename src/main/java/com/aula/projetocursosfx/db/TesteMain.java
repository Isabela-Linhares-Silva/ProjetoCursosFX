package com.aula.projetocursosfx.db;

import com.aula.projetocursosfx.model.dao.AlunoDao;
import com.aula.projetocursosfx.model.dao.impl.AlunoDaoJDBC;

import java.util.Scanner;

public class TesteMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*System.out.print("digite o id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("digite o nome: ");
        String nome = sc.nextLine();
        System.out.print("digite o email: ");
        String email = sc.next();
        */
        AlunoDao aluno = new AlunoDaoJDBC(DB.getConnection());

        //aluno.insert(new Aluno(id, nome, email));
        //System.out.println("aluno inserido com sucesso");
        //INSERIR!!
//-------------------------------------------------------------------//

        /*System.out.print("id que quer atualizar: ");
        int id = sc.nextInt();

        Aluno resultado = aluno.findByID(id);
        if (resultado == null){
            System.out.println("aluno nao econtrado.");
        }
        else{
            sc.nextLine();
            System.out.print("novo nome: ");
            resultado.setNome(sc.nextLine());
            System.out.print("novo email: ");
            resultado.setEmail(sc.next());

            aluno.update(resultado);
            System.out.println("aluno atualizado!");
        }*/
        //ATUALIZAR!!
//-------------------------------------------------------------------//

        /*System.out.print("id do aluno que será deletado: ");
        int id = sc.nextInt();
        aluno.deleteByID(id);
        System.out.println("aluno deletado");*/
        //DELETAR
//-------------------------------------------------------------------//
        /*System.out.print("digite o id do aluno que quer procurar: ");
        int id = sc.nextInt();
        Aluno resultado = aluno.findByID(id);
        if (resultado == null){
            System.out.println("aluno nao econtrado.");
        }else{
            System.out.println(resultado);
        }*/
        //ENCONTRAR
//-------------------------------------------------------------------//

        //aluno.findAll().forEach(System.out::println);
        //ENCONTRAR TODOS
//-------------------------------------------------------------------//

    }
}

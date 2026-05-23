package com.aula.projetocursosfx.db;

import com.aula.projetocursosfx.model.dao.AlunoDao;
import com.aula.projetocursosfx.model.dao.CursoDao;
import com.aula.projetocursosfx.model.dao.impl.AlunoDaoJDBC;
import com.aula.projetocursosfx.model.dao.impl.CursoDaoJDBC;
import com.aula.projetocursosfx.model.entities.Aluno;
import com.aula.projetocursosfx.model.entities.Curso;
import com.aula.projetocursosfx.model.entities.Professor;

import java.util.Scanner;

public class TesteMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*System.out.print("digite o nome: ");
        String nome = sc.nextLine();
        System.out.print("digite o email: ");
        String email = sc.next();*/

        AlunoDao aluno = new AlunoDaoJDBC(DB.getConnection());

        /*aluno.insert(new Aluno(nome, email));
        System.out.println("aluno inserido com sucesso");*/
        //INSERIR ALUNO!!
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
        //ATUALIZAR ALUNO!!
//-------------------------------------------------------------------//

        /*System.out.print("id do aluno que será deletado: ");
        int id = sc.nextInt();
        aluno.deleteByID(id);
        System.out.println("aluno deletado");*/
        //DELETAR ALUNO!!
//-------------------------------------------------------------------//
        /*System.out.print("digite o id do aluno que quer procurar: ");
        int id = sc.nextInt();
        Aluno resultado = aluno.findByID(id);
        if (resultado == null){
            System.out.println("aluno nao econtrado.");
        }else{
            System.out.println(resultado);
        }*/
        //ENCONTRAR ALUNO!!
//-------------------------------------------------------------------//

        //aluno.findAll().forEach(System.out::println);
        //ENCONTRAR TODOS!!
//-------------------------------------------------------------------//

        /*System.out.print("digite o id: ");
        Integer id = sc.nextInt();
        System.out.print("digite o nome: ");
        String nome = sc.nextLine();
        System.out.print("digite a carga horaria: ");
        Integer cargaHoraria = sc.nextInt();
        System.out.print("digite o preco: ");
        Double preco = sc.nextDouble();
        System.out.print("digite o professor (id): ");
        Integer professorId = sc.nextInt();
        Professor professor = new Professor(professorId);

        // cria o curso com o professor

        //aluno.insert(new Aluno(id, nome, email));
        CursoDao curso = new CursoDaoJDBC(DB.getConnection());

        curso.insert(new Curso(id, nome, cargaHoraria, preco, professor));

        System.out.println("Curso inserido com sucesso!");*/





    }
}

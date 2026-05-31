package com.aula.projetocursosfx.db;

import com.aula.projetocursosfx.model.dao.AlunoDao;
import com.aula.projetocursosfx.model.dao.CursoDao;
import com.aula.projetocursosfx.model.dao.MatriculaDao;
import com.aula.projetocursosfx.model.dao.ProfessorDao;
import com.aula.projetocursosfx.model.dao.impl.AlunoDaoJDBC;
import com.aula.projetocursosfx.model.dao.impl.CursoDaoJDBC;
import com.aula.projetocursosfx.model.dao.impl.MatriculaDaoJDBC;
import com.aula.projetocursosfx.model.dao.impl.ProfessorDaoJDBC;
import com.aula.projetocursosfx.model.entities.Aluno;
import com.aula.projetocursosfx.model.entities.Curso;
import com.aula.projetocursosfx.model.entities.Matricula;
import com.aula.projetocursosfx.model.entities.Professor;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        //ENCONTRAR TODOS ALUNOS!!
//-------------------------------------------------------------------//

        /*System.out.print("nome do professor: ");
        String nome = sc.nextLine();
        System.out.print("especialidade do professor: ");
        String especialidade = sc.nextLine();*/

        ProfessorDao professor = new ProfessorDaoJDBC(DB.getConnection());

        /*professor.insert(new Professor(nome, especialidade));
        System.out.println("professor inserido com sucesso!");*/

        //INSERIR PROFESSOR!!
//-------------------------------------------------------------------//

        /*System.out.print("id que quer atualizar: ");
        int id = sc.nextInt();

        Professor resultado = professor.findByID(id);
        if (resultado == null){
            System.out.println("professor nao encontrado.");
        }
        else{
            sc.nextLine();
            System.out.print("novo nome: ");
            resultado.setNome(sc.nextLine());
            System.out.print("nova especialidade: ");
            resultado.setEspecialidade(sc.next());

            professor.update(resultado);
            System.out.println("professor atualizado!");
        }*/
        //ATUALIZAR PROFESSOR!!
//-------------------------------------------------------------------//

        /*System.out.print("id do professor que será deletado: ");
        int id = sc.nextInt();
        professor.deleteByID(id);
        System.out.println("professor deletado");*/
        //DELETAR PROFESSOR!!
//-------------------------------------------------------------------//
        /*System.out.print("digite o id do professor que quer procurar: ");
        int id = sc.nextInt();
        Professor resultado = professor.findByID(id);
        if (resultado == null){
            System.out.println("professor nao encontrado.");
        }else{
            System.out.println(resultado);
        }*/
        //ENCONTRAR PROFESSOR!!
//-------------------------------------------------------------------//
        //professor.findAll().forEach(System.out::println);
        //ENCONTRAR TODOS PROFESSORES!!

//-------------------------------------------------------------------//

       /* System.out.print("digite o nome do curso: ");
        String nome = sc.nextLine();
        System.out.print("digite a carga horaria: ");
        Integer carga_horaria = sc.nextInt();
        System.out.print("digite o preco: ");
        Double preco = sc.nextDouble();
        System.out.print("digite o professor (id): ");
        Integer professorId = sc.nextInt();
        Professor professorCurso = new Professor(professorId);*/

        CursoDao curso = new CursoDaoJDBC(DB.getConnection());

        // cria o curso com o professor
        //curso.insert(new Curso(nome, carga_horaria, preco, professorCurso));

        //System.out.println("Curso inserido com sucesso!");
        //INSERIR CURSO!!
//-------------------------------------------------------------------//

        /*System.out.print("id que quer atualizar: ");
        int id = sc.nextInt();

        Curso resultado = curso.findByID(id);
        if (resultado == null){
            System.out.println("curso nao encontrado.");
        }
        else{
            sc.nextLine();
            System.out.print("novo nome: ");
            resultado.setNome(sc.nextLine());
            System.out.print("nova cargahoraria: ");
            resultado.setCargaHoraria(sc.nextInt());
            System.out.print("novo preco: ");
            resultado.setPreco(sc.nextDouble());
            System.out.print("novo id do professor: ");
            int professorId = sc.nextInt();

            Professor novoProfessor = new Professor(professorId);
            resultado.setProfessor(novoProfessor);

            curso.update(resultado);
            //ATUALIZAR CURSO!!
        }*/
//-------------------------------------------------------------------//

       /* System.out.print("id do curso que será deletado: ");
        int id = sc.nextInt();
        curso.deleteByID(id);
        System.out.println("curso deletado");*/
        //DELETAR CURSO!!
//------------------------------------------------------------------//-
        /*System.out.print("digite o id do curso que quer procurar: ");
        int id = sc.nextInt();
        Curso resultado = curso.findByID(id);
        if (resultado == null){
            System.out.println("curso nao encontrado.");
        }else{
            System.out.println(resultado);
        }*/
        //ENCONTRAR CURSO!!
//-------------------------------------------------------------------//

        //curso.findAll().forEach(System.out::println);
        //ENCONTRAR TODOS CURSOS!!
//-------------------------------------------------------------------//


        /*System.out.print("digite o status: ");
        String status = sc.nextLine();
        System.out.print("digite o id do aluno: ");
        Integer alunoID = sc.nextInt();
        Aluno alunoMatricula = new Aluno(alunoID);


        System.out.print("digite o id do curso: ");
        Integer cursoID = sc.nextInt();
        CursoDao cursoDao = new CursoDaoJDBC(DB.getConnection());
        Curso cursoMatricula = cursoDao.findByID(cursoID);

        Double valor = cursoMatricula.getPreco();


        String status_pagamento = "PAGO";
        LocalDate data_pagamento = LocalDate.now(); //LOGICA FALTANDO!!
        */
        MatriculaDao matricula = new MatriculaDaoJDBC(DB.getConnection());
        //Matricula m = new Matricula(null, status, alunoMatricula, cursoMatricula, valor, data_pagamento, status_pagamento);

        //matricula.insert(m);

        //System.out.println("Matricula inserida com sucesso!");
        //INSERIR MATRICULA!!
//-------------------------------------------------------------------//

        /*System.out.print("id que quer atualizar: ");
        int id = sc.nextInt();

        Matricula resultado = matricula.findByID(id);
        if (resultado == null){
            System.out.println("Matricula nao encontrado.");
        }
        else{
            sc.nextLine();
            System.out.print("novo status do curso: ");
            String status = sc.nextLine();
            System.out.print("novo status pagamento: ");
            String status_pagamento = sc.nextLine();

            resultado.setStatus(status);
            resultado.setStatusPagamento(status_pagamento);
            resultado.setDataPagamento(LocalDate.now());

            matricula.update(resultado);
            System.out.println("Matricula atualizada com sucesso!!");
            //ATUALIZAR MATRICULA!!
        }*/
//-------------------------------------------------------------------//

        /*System.out.print("id da matricula que será deletado: ");
        int id = sc.nextInt();
        matricula.deleteByID(id);
        System.out.println("matricula deletada");*/
        //DELETAR MATRICULA!!
//-------------------------------------------------------------------//

        /*System.out.print("digite o id da matricula que quer procurar: ");
        int id = sc.nextInt();
        Matricula resultado = matricula.findByID(id);
        if (resultado == null){
            System.out.println("matricula nao econtrado.");
        }else{
            System.out.println(resultado);
        }*/
        //ENCONTRAR MATRICULA!!
//-------------------------------------------------------------------//

        //matricula.findAll().forEach(System.out::println);
        //ENCONTRAR TODAS AS MATRICULAS!!
//-------------------------------------------------------------------//

    }
}

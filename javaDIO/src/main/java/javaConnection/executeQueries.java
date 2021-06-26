package javaConnection;

import java.util.List;

public class executeQueries {

    public static void main(String[] args) {

        /*     Consulta    */
        AlunosDAO alunosDAO = new AlunosDAO();

        List<Aluno> aluno = alunosDAO.list();

        aluno.stream().forEach(System.out::println);

        System.out.println("----------------------------------------------------");

        /*Consulta com filtro*/
        Aluno consultaAluno = AlunosDAO.getById(2);

        System.out.println(consultaAluno);

        System.out.println("----------------------------------------------------");

        //Adicionar aluno

        Aluno addAluno = new Aluno(5,"Matheus", 25, "SP");

        System.out.println(addAluno);

        //Deletar aluno
        aluno.stream().forEach(System.out::println);

        AlunosDAO.delete(1);

        System.out.println("----------------------------------------------------");

        //Atualizar aluno
        alunosDAO.list().stream().forEach(System.out::println);

        Aluno alunoATT = AlunosDAO.getById(4);
        alunoATT.setNome("Tiago");
        alunoATT.setIdade(20);
        alunoATT.setEstado("SC");

        alunosDAO.update(alunoATT);

        System.out.println("----------------------------------------------------");


    }


}

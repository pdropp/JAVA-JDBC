package javaConnection;

import jdk.jshell.SourceCodeAnalysis;

public class Aluno {

    private int id;
    private String nome;
    private int idade;
    private String estado;

    public Aluno(int id, String nome, int idade, String estado) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
    }

    public Aluno(String nome, int idade, String estado) {
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
    }

    public Aluno() {
    }

    public int getId() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Aluno \n");
        sb.append("ID = ").append(id).append('\n');
        sb.append("NOME = ").append(nome).append('\n');
        sb.append("IDADE = ").append(idade).append('\n');
        sb.append("ESTADO = ").append(estado).append('\n');

        return sb.toString();
    }

}


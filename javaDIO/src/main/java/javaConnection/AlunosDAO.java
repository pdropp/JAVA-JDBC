package javaConnection;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunosDAO {


    //Preparar lista que irá retornar alunos após consultar o banco de dados

    public List<Aluno> list() {

        List<Aluno> alunos = new ArrayList<>();

        try (Connection conn = ConnectionJDBC.getConnection()) {

            //PreparedStatement prps = conn.prepareStatement("SELECT * FROM aluno");
            PreparedStatement prepared = conn.prepareStatement("Select * from aluno");
            ResultSet rs = prepared.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("estado"));

                alunos.add(aluno);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alunos;


    }

    public static Aluno getById(int id){
        Aluno aluno = new Aluno();

        try(Connection conn = ConnectionJDBC.getConnection()){
            //Preparar consulta
            String sql = "SELECT * FROM aluno WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            //ExecuteQuery quando é para exibir, para alterar dados executeUpdate
            //Executa consulta e armazena o retorno da consulta no objeto

            ResultSet rs = stmt.executeQuery();

            //Guarda os valores retornados da tabela aluno no objeto aluno
            if (rs.next()){
                aluno.setID(rs.getInt("ID"));
                aluno.setNome(rs.getString("NOME"));
                aluno.setIdade(rs.getInt("IDADE"));
                aluno.setEstado(rs.getString("ESTADO"));
            }


        } catch (SQLException e) {
            System.out.println("Listagem de alunos FALHOU");
            e.printStackTrace();
        }

        return aluno;

    }

    public static void criarAluno(){

        Aluno aluno = new Aluno();
        try(Connection conn = ConnectionJDBC.getConnection()){

            //Preparar SQL para inserção de dados
            String sql = "INSERT INTO aluno(id, nome, idade, estado) VALUES (?,?,?,?)";

            //Preparar statement com os parametros
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, aluno.getId());
                stmt.setString(2, aluno.getNome());
                stmt.setInt(3, aluno.getIdade());
                stmt.setString(4, aluno.getEstado());

                int rowsAffected = stmt.executeUpdate();


            System.out.println("Inserção bem sucedida"+ rowsAffected + "linha");

        }catch (SQLException e){
            System.out.println("Insenção falhou");
            e.printStackTrace();
        }
    }

    public static void delete(int id){
        try(Connection conn = ConnectionJDBC.getConnection()){
            //Preparar SQL para deletar uma linha
            String sql = "DELETE FROM aluno WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            //Executa dele e armazena o numero de linhas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Delete bem sucedido! Foi deletada "+ rowsAffected + " linha");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void update(Aluno aluno){
        try(Connection conn = ConnectionJDBC.getConnection()){
            String sql = "UPDATE aluno SET nome = ?, idade = ?, estado = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getEstado());
            stmt.setInt(4, aluno.getId());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Atualização bem sucedida"+ rowsAffected + "linha");
        }catch (SQLException e){
            System.out.println("Atualização falhou");
            e.printStackTrace();
        }
    }

}




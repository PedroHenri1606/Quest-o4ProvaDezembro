package dao;

import factory.Factory;
import model.Biblioteca;
import model.Genero;
import model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaDAO {

    Connection connection;

    public BibliotecaDAO(){ this.connection = new Factory().getConection();}

    public void criarTabelaBiblioteca(){

        String sql = "CREATE TABLE IF NOT EXISTS biblioteca("+
                     "id_biblioteca bigint primary key auto_increment,"+
                     "nome VARCHAR(45),"+
                     "senha VARCHAR(45))";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void adicionarBiblioteca(Biblioteca biblioteca){

        String sql = "INSERT INTO Questao4Prova.biblioteca (nome,senha) value (?,?)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,biblioteca.getNome());
            statement.setString(2,biblioteca.getSenha());
            statement.execute();
            statement.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean login(String nome, String senha){

        boolean status;

        String sql ="SELECT * FROM Questao4Prova.biblioteca where (nome = ? AND senha = ?)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,nome);
            statement.setString(2,senha);
            ResultSet resultSet = statement.executeQuery();
            status = resultSet.next();
            statement.close();
            return status;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Biblioteca determinarBibliotecaAtual(String nome, String senha){

        boolean status;

        String sql = "SELECT * FROM Questao4Prova.biblioteca where (nome = ? AND senha = ?)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1,nome);
            statement.setString(2,senha);

            ResultSet resultSet = statement.executeQuery();
            status = resultSet.next();
            Biblioteca tmp = new Biblioteca();

            if(status){
                tmp.setNome(resultSet.getString("nome"));
                tmp.setSenha(resultSet.getString("senha"));
            }
            statement.close();
            return tmp;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public List<Biblioteca> listar(){

        String sql = "SELECT * FROM questao4prova.biblioteca";

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList bibliotecas = new ArrayList();

            while (resultSet.next()) {
                Biblioteca biblioteca = new Biblioteca();
                biblioteca.setId(resultSet.getLong("id_biblioteca"));
                biblioteca.setNome(resultSet.getString("nome"));

                bibliotecas.add(biblioteca);
            }
            return bibliotecas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Biblioteca determinaBiblioteca(int id) {

        String sql = "SELECT * FROM biblioteca where id_biblioteca = " + id;
        List<Biblioteca> bibliotecas = new ArrayList();
        Biblioteca biblioteca = new Biblioteca();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                biblioteca.setId(resultSet.getInt("id_biblioteca"));
                biblioteca.setNome(resultSet.getString("nome"));
                bibliotecas.add(biblioteca);
            }
            statement.execute();
            statement.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return biblioteca;
    }
}

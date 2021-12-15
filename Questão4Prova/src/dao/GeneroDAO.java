package dao;


import factory.Factory;
import model.Genero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO {

    Connection connection;

    public GeneroDAO(){ this.connection = new Factory().getConection();}

    public void criarTabelaGenero(){

        String sql = "CREATE TABLE IF NOT EXISTS genero("+
                "id_genero bigint primary key auto_increment,"+
                "nome VARCHAR(45))";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void adicionarGenero(Genero genero){

        String sql = "INSERT INTO Questao4Prova.genero (nome) value (?)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,genero.getNome());
            statement.execute();
            statement.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void editarGenero(Genero genero){

        String sql = "UPDATE Questao4Prova.genero set nome = ? where id_genero = ?";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,genero.getNome());
            statement.setLong(2,genero.getId());
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Genero> listar(){

        String sql = "SELECT * FROM questao4prova.genero";

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList generos = new ArrayList();

            while (resultSet.next()) {
                Genero genero = new Genero();
                genero.setId(resultSet.getInt("id_genero"));
                genero.setNome(resultSet.getString("nome"));
                generos.add(genero);
            }
            return generos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Genero determinaGenero(int id) {

        String sql = "SELECT * FROM genero where id_genero = " + id;
        List<Genero> generos = new ArrayList();
        Genero genero = new Genero();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                genero.setId(resultSet.getInt("id_genero"));
                genero.setNome(resultSet.getString("nome"));
                generos.add(genero);
            }
            statement.execute();
            statement.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return genero;
    }
}

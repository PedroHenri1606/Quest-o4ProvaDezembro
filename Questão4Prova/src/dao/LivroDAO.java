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

public class LivroDAO {

    Connection connection;

    public LivroDAO(){ this.connection = new Factory().getConection();}

    public void criarTabelaLivro(){

        String sql = "CREATE TABLE IF NOT EXISTS livro("+
                "id_livro bigint primary key auto_increment,"+
                "nome VARCHAR(45),"+
                "quantFolhas bigint,"+
                "genero bigint,"+
                "foreign key (genero) references genero(id_genero),"+
                "autor VARCHAR(45)," +
                "idBiblioteca bigint," +
                "foreign key (idBiblioteca) references biblioteca(id_biblioteca));";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void adicionarLivro(Livro livro,Biblioteca biblioteca){

        String sql = "INSERT INTO Questao4Prova.livro (nome,quantFolhas,genero,autor,idBiblioteca) value (?,?,?,?,?)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,livro.getNome());
            statement.setLong(2,livro.getQuantFolhas());
            statement.setLong(3,livro.getGenero().getId());
            statement.setString(4,livro.getAutor());
            statement.setLong(5,livro.getIdBiblioteca().getId());
            statement.execute();
            statement.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Livro> listar(Genero genero, Biblioteca biblioteca){

        String sql = "SELECT * FROM questao4prova.livro";

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList livros = new ArrayList();

            while (resultSet.next()) {
                Livro livro = new Livro();
                livro.setId(resultSet.getInt("id_livro"));
                livro.setNome(resultSet.getString("nome"));
                livro.setQuantFolhas(resultSet.getLong("quantFolhas"));
                livro.setGenero(genero);
                livro.setAutor(resultSet.getString("autor"));
                livro.setIdBiblioteca(biblioteca);


                livros.add(livro);
            }
            return livros;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Livro> listarPorBiblioteca(Biblioteca biblioteca, Genero genero){


        String sql = "SELECT * FROM questao4prova.livro where idBiblioteca = "+ biblioteca.getId();

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList livros = new ArrayList();

            while (resultSet.next()) {
                Livro livro = new Livro();
                livro.setId(resultSet.getInt("id_livro"));
                livro.setNome(resultSet.getString("nome"));
                livro.setQuantFolhas(resultSet.getLong("quantFolhas"));
                livro.setGenero(genero);
                livro.setAutor(resultSet.getString("autor"));
                livro.setIdBiblioteca(biblioteca);


                livros.add(livro);
            }
            return livros;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Livro> listarPorGenero(Biblioteca biblioteca, Genero genero){


        String sql = "SELECT * FROM questao4prova.livro where genero = "+ genero.getId();

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList livros = new ArrayList();

            while (resultSet.next()) {
                Livro livro = new Livro();
                livro.setId(resultSet.getInt("id_livro"));
                livro.setNome(resultSet.getString("nome"));
                livro.setQuantFolhas(resultSet.getLong("quantFolhas"));
                livro.setGenero(genero);
                livro.setAutor(resultSet.getString("autor"));
                livro.setIdBiblioteca(biblioteca);


                livros.add(livro);
            }
            return livros;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

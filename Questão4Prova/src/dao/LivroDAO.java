package dao;

import factory.Factory;
import model.Genero;
import model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
                "autor VARCHAR(45))";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void adicionarLivro(Livro livro){

        String sql = "INSERT INTO Questao4Prova.livro (nome,quantFolhas,genero,autor) value (?,?,?,?)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,livro.getNome());
            statement.setLong(2,livro.getQuantFolhas());
            statement.setLong(3,livro.getGenero().getId());
            statement.setString(4,livro.getAutor());
            statement.execute();
            statement.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}

package view;

import controller.BibliotecaController;
import model.Biblioteca;

import javax.swing.*;
import java.util.List;

public class BibliotecaView {


    public String menuInicioExibir() {
        String[] escolhas = {"1", "2"};
        String menuLogin = "[1] - Login\n[2] - Cadastrar nova Biblioteca\n";
        return (String) JOptionPane.showInputDialog(null, "   Bem Vindo\n" + menuLogin, "BiBlioshow", JOptionPane.INFORMATION_MESSAGE, null, escolhas, escolhas[0]);
    }


    public void menuInicio() {

        BibliotecaController bibliotecaController = new BibliotecaController();

        while (true) {

            String login = menuInicioExibir();

            switch (login) {
                case "1":
                    this.login();
                    break;
                case "2":
                    cadastrarBiblioteca();
                    break;
            }
        }
    }

    public void cadastrarBiblioteca() {

        Biblioteca biblioteca = new Biblioteca();
        BibliotecaController bibliotecaController = new BibliotecaController();

        String nome = JOptionPane.showInputDialog(null, "      CADASTRO BIBLIOTECA\n\n" + "Nome: ", "BiBlioshow", JOptionPane.INFORMATION_MESSAGE);
        biblioteca.setNome(nome);

        String senha = JOptionPane.showInputDialog(null, "      CADASTRO BIBLIOTECA\n\n" + "Senha: ", "BiBlioshow", JOptionPane.INFORMATION_MESSAGE);
        biblioteca.setSenha(senha);

        bibliotecaController.adicionarBiblioteca(biblioteca);
    }

    public void login() {

        Biblioteca biblioteca = new Biblioteca();
        BibliotecaController bibliotecaController = new BibliotecaController();

        String nome = JOptionPane.showInputDialog(null, "      LOGIN BIBLIOTECA\n\n" + "Nome: ", "BiBlioshow", JOptionPane.INFORMATION_MESSAGE);
        String senha = JOptionPane.showInputDialog(null, "      LOGIN BIBLIOTECA\n\n" + "Senha: ", "BiBlioshow", JOptionPane.INFORMATION_MESSAGE);

        if (bibliotecaController.login(nome, senha)) {
            biblioteca = bibliotecaController.determinarBibliotecaAtual(nome,senha);
            this.menuBiblioteca(biblioteca);
        } else {
            this.menuInicio();
        }
    }

    public void menuBiblioteca(Biblioteca biblioteca){

        GeneroView generoView = new GeneroView();
        LivroView livroView = new LivroView();

        while(true){

            String escolha = menuBibliotecaExibir(biblioteca);

            switch (escolha){
                case "1":
                    generoView.adicionarGenero();
                    break;
                case "2":
                    int id = 0; id = generoView.escolhendoGenero(id);
                    generoView.editarGenero(id);
                    break;
                case "3":
                    livroView.cadastrarLivro();
                    break;
                case "4":
            }
        }

    }

    public String menuBibliotecaExibir(Biblioteca bibliotecaAtual){
        String[] escolhas = {"1", "2","3","4","5","6"};
        String menuBiblioteca = "[1] - Cadastrar Gênero\n[2] - Editar Gênero\n[3] - Cadastrar Livro\n[4] - Dados do Livro\n[5] - Listar Todos Livros\n[6] - Listar Todos os Livros de um Gênero";
        return (String) JOptionPane.showInputDialog(null, "   Bem Vindo: "+ bibliotecaAtual.getNome() +"\n"+ menuBiblioteca , "BiBlioshow", JOptionPane.INFORMATION_MESSAGE, null, escolhas, escolhas[0]);
    }
}

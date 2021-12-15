package view;

import controller.GeneroController;
import controller.LivroController;
import model.Livro;

import javax.swing.*;

public class LivroView {
    public void cadastrarLivro(){

        Livro livro = new Livro();

        String nome = JOptionPane.showInputDialog(null, "      CADASTRO LIVRO\n\n" + "Nome: ", "BiBlioshow", JOptionPane.INFORMATION_MESSAGE);
        String quantFolhas = JOptionPane.showInputDialog(null, "      CADASTRO LIVRO\n\n" + "Quantidade de Folhas: ", "BiBlioshow", JOptionPane.INFORMATION_MESSAGE);

        GeneroView generoView = new GeneroView();
        GeneroController generoController = new GeneroController();
        int id = 0;
        id = generoView.escolhendoGenero(id);

        String autor = JOptionPane.showInputDialog(null, "      CADASTRI LIVRO\n\n" + "Autor: ", "BiBlioshow", JOptionPane.INFORMATION_MESSAGE);


        livro.setNome(nome);
        livro.setQuantFolhas(Long.parseLong(quantFolhas));
        livro.setGenero(generoController.selecionaGenero(id));
        livro.setAutor(autor);

        LivroController livroController = new LivroController();
        livroController.adicionarLivro(livro);
    }

}

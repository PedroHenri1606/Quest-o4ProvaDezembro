package controller;

import dao.LivroDAO;
import model.Livro;

public class LivroController {

    public void criarTabelaLivro(){LivroDAO livroDAO = new LivroDAO();livroDAO.criarTabelaLivro();}
    public void adicionarLivro(Livro livro){LivroDAO livroDAO = new LivroDAO(); livroDAO.adicionarLivro(livro);}
}

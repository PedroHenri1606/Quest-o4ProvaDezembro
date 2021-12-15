package controller;

import dao.LivroDAO;
import model.Biblioteca;
import model.Genero;
import model.Livro;

import java.util.List;

public class LivroController {

    public void criarTabelaLivro(){LivroDAO livroDAO = new LivroDAO();livroDAO.criarTabelaLivro();}
    public void adicionarLivro(Livro livro,Biblioteca biblioteca){LivroDAO livroDAO = new LivroDAO(); livroDAO.adicionarLivro(livro,biblioteca);}
    public List<Livro>listar(Genero genero, Biblioteca biblioteca){LivroDAO livroDAO = new LivroDAO(); return livroDAO.listar(genero,biblioteca);}
    public List<Livro>listarPorBiblioteca(Genero genero,Biblioteca biblioteca){ LivroDAO livroDAO = new LivroDAO(); return livroDAO.listarPorBiblioteca(biblioteca,genero);}
    public List<Livro>listarPorGenero(Genero genero, Biblioteca biblioteca){ LivroDAO livroDAO = new LivroDAO(); return livroDAO.listarPorGenero(biblioteca, genero);}
}

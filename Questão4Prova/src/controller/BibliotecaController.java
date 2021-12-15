package controller;

import dao.BibliotecaDAO;
import model.Biblioteca;

import java.util.List;

public class BibliotecaController {

    public void criarTabelaBiblioteca(){BibliotecaDAO bibliotecaDAO = new BibliotecaDAO(); bibliotecaDAO.criarTabelaBiblioteca();}
    public void adicionarBiblioteca(Biblioteca biblioteca){ BibliotecaDAO bibliotecaDAO = new BibliotecaDAO(); bibliotecaDAO.adicionarBiblioteca(biblioteca);}
    public boolean login(String nome,String senha){ BibliotecaDAO bibliotecaDAO = new BibliotecaDAO(); return bibliotecaDAO.login(nome,senha);}
    public Biblioteca determinarBibliotecaAtual(String nome,String senha){ BibliotecaDAO bibliotecaDAO = new BibliotecaDAO(); return bibliotecaDAO.determinarBibliotecaAtual(nome,senha);}
    public List<Biblioteca> listar(){ BibliotecaDAO bibliotecaDAO = new BibliotecaDAO(); return bibliotecaDAO.listar();}
    public Biblioteca selecionaBiblioteca(int id){BibliotecaDAO bibliotecaDAO = new BibliotecaDAO(); return bibliotecaDAO.determinaBiblioteca(id);}
}

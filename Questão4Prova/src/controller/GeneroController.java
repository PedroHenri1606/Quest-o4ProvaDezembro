package controller;

import dao.GeneroDAO;
import model.Genero;

import java.util.List;

public class GeneroController {

    public void criarTabelaGenero(){GeneroDAO generoDAO = new GeneroDAO(); generoDAO.criarTabelaGenero();}
    public void adicionarGenero(Genero genero){ GeneroDAO generoDAO = new GeneroDAO(); generoDAO.adicionarGenero(genero);}
    public void editarGenero(Genero genero){ GeneroDAO generoDAO = new GeneroDAO(); generoDAO.editarGenero(genero);}
    public List<Genero> listar(){ GeneroDAO generoDAO = new GeneroDAO(); return generoDAO.listar();}
    public Genero selecionaGenero(int id){ GeneroDAO generoDAO = new GeneroDAO(); return generoDAO.determinaGenero(id);}
}

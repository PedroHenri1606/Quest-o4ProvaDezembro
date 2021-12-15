package view;

import controller.BibliotecaController;
import controller.GeneroController;
import controller.LivroController;
import model.Biblioteca;
import model.Genero;
import model.Livro;

import javax.swing.*;
import java.util.List;
import java.util.StringTokenizer;

public class LivroView {
    public void cadastrarLivro() {

        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro();

        String nome = JOptionPane.showInputDialog(null, "      CADASTRO LIVRO\n\n" + "Nome: ", "BiBlioshow", JOptionPane.INFORMATION_MESSAGE);
        String quantFolhas = JOptionPane.showInputDialog(null, "      CADASTRO LIVRO\n\n" + "Quantidade de Folhas: ", "BiBlioshow", JOptionPane.INFORMATION_MESSAGE);

        GeneroView generoView = new GeneroView();
        GeneroController generoController = new GeneroController();
        int id = 0;
        id = generoView.escolhendoGenero(id);

        String autor = JOptionPane.showInputDialog(null, "      CADASTRO LIVRO\n\n" + "Autor: ", "BiBlioshow", JOptionPane.INFORMATION_MESSAGE);


        livro.setNome(nome);
        livro.setQuantFolhas(Long.parseLong(quantFolhas));
        livro.setGenero(generoController.selecionaGenero(id));
        livro.setAutor(autor);

        BibliotecaController bibliotecaController = new BibliotecaController();
        livro.setIdBiblioteca(bibliotecaController.selecionaBiblioteca(id));

        LivroController livroController = new LivroController();
        livroController.adicionarLivro(livro,biblioteca);
    }

    public int escolherLivro(int id) {

        Biblioteca biblioteca = new Biblioteca();
        GeneroController generoController = new GeneroController();
        LivroController livroController = new LivroController();
        Genero genero = generoController.selecionaGenero(id);

        List<Livro> list;
        list = livroController.listar(genero,biblioteca);
        String[] object = new String[list.size()];
        JFrame jFrame = new JFrame();
        jFrame.setAlwaysOnTop(true);
        int i = 0;

        try {
            for (Livro livro1 : list) {
                object[i] = (livro1.getId() + " | " + livro1.getNome() + " | " + "Autor: " + livro1.getAutor());
                i++;
            }

            Object selectionObjetec = JOptionPane.showInputDialog(jFrame, "ESCOLHA UM LIVRO:", "BiBlioshow", JOptionPane.QUESTION_MESSAGE, null, object, object[0]);
            String tmp = selectionObjetec.toString();
            StringTokenizer st = new StringTokenizer(tmp);
            id = Integer.valueOf(st.nextToken(" | "));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public void visualizarLivro(int id, Genero genero) {

        Biblioteca biblioteca = new Biblioteca();
        LivroController livroController = new LivroController();
        GeneroController generoController = new GeneroController();
        genero = generoController.selecionaGenero(id);

        List<Livro> livros = livroController.listar(genero,biblioteca);
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        String output = "==============================================\n";

        for (Livro livro : livros) {

            String tmp1 = "Id: " + livro.getId() + "\n" +
                    "Titulo: " + livro.getNome() + "\n" +
                    "Gênero: " + livro.getGenero().getNome() + "\n" +
                    "Quantidade de Páginas: " + livro.getQuantFolhas() + "\n" +
                    "Autor: " + livro.getAutor() + "\n" +
                    "==============================================\n";
            output += tmp1 + "\n";
        }
        if (livros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum Livro Econtrado!", "BiBlioshow", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "         Detalhes do Livro\n" + output, "Biblioshow", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void visualizarPorId(int id) {

        LivroController livroController = new LivroController();
        GeneroController generoController = new GeneroController();
        BibliotecaController bibliotecaController = new BibliotecaController();

        Biblioteca biblioteca = bibliotecaController.selecionaBiblioteca(id);
        Genero genero = generoController.selecionaGenero(id);

        List<Livro> livros = livroController.listarPorBiblioteca(genero, biblioteca);
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        String output = "==============================================\n";

        for (Livro livro : livros) {

            String tmp1 = "Id: " + livro.getId() + "\n" +
                    "Titulo: " + livro.getNome() + "\n" +
                    "Gênero: " + livro.getGenero().getNome() + "\n" +
                    "Quantidade de Páginas: " + livro.getQuantFolhas() + "\n" +
                    "Autor: " + livro.getAutor() + "\n" +
                    "==============================================\n";
            output += tmp1 + "\n";
        }
        if (livros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum Livro Econtrado!", "BiBlioshow", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "         Detalhes do Livro\n" + output, "Biblioshow", JOptionPane.INFORMATION_MESSAGE);
        }
    }

        public void visualizarPorGenero(int id){

            LivroController livroController = new LivroController();
            GeneroController generoController = new GeneroController();
            BibliotecaController bibliotecaController = new BibliotecaController();

            Biblioteca biblioteca = bibliotecaController.selecionaBiblioteca(id);
            Genero genero = generoController.selecionaGenero(id);

            List<Livro> livros = livroController.listarPorGenero(genero,biblioteca);
            JFrame frame = new JFrame();
            frame.setAlwaysOnTop(true);
            String output = "==============================================\n";

            for (Livro livro : livros) {

                String tmp1 = "Id: " + livro.getId() + "\n" +
                        "Titulo: " + livro.getNome() + "\n" +
                        "Gênero: " + livro.getGenero().getNome() + "\n" +
                        "Quantidade de Páginas: " + livro.getQuantFolhas() + "\n" +
                        "Autor: " + livro.getAutor() + "\n" +
                        "==============================================\n";
                output += tmp1 + "\n";
            }
            if (livros.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum Livro Econtrado!", "BiBlioshow", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "         Detalhes do Livro\n" + output, "Biblioshow", JOptionPane.INFORMATION_MESSAGE);
            }
    }
}

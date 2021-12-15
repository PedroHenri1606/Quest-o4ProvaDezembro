package view;

import controller.GeneroController;
import model.Genero;

import javax.swing.*;
import java.util.List;
import java.util.StringTokenizer;

public class GeneroView {

    public void adicionarGenero(){

        GeneroController generoController = new GeneroController();
        Genero genero = new Genero();

        String nome = JOptionPane.showInputDialog(null, "      CADASTRO GENERO\n\n" + "Nome: ", "BiBlioshow", JOptionPane.INFORMATION_MESSAGE);
        genero.setNome(nome);
        generoController.adicionarGenero(genero);
    }

    public int escolhendoGenero(int id){


        GeneroController generoController = new GeneroController();

        List<Genero> list;
        list = generoController.listar();
        String[] object = new String[list.size()];
        JFrame jFrame = new JFrame();
        jFrame.setAlwaysOnTop(true);
        int i = 0;

        try {
            for(Genero genero: list){
                object[i] = (genero.getId()+ "|" + genero.getNome());
                i++;
            }

            Object selectionObjetec = JOptionPane.showInputDialog(jFrame,"ESCOLHA UM GENERO:","BiBlioshow",JOptionPane.QUESTION_MESSAGE,null,object,object[0]);
            String tmp = selectionObjetec.toString();
            StringTokenizer st = new StringTokenizer(tmp);
            id = Integer.valueOf(st.nextToken("|"));
        } catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }

    public void editarGenero(int id){

        Genero genero = new Genero();
        GeneroController generoController = new GeneroController();

        String nome = JOptionPane.showInputDialog(null, "      EDITAR GENERO\n\n" + "Nome: ", "BiBlioshow", JOptionPane.INFORMATION_MESSAGE);
        genero.setNome(nome);
        genero.setId(id);
        generoController.editarGenero(genero);


    }
}
